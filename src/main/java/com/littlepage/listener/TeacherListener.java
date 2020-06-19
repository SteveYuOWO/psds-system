package com.littlepage.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.littlepage.entity.Major;
import com.littlepage.entity.Teacher;
import com.littlepage.service.*;
import com.littlepage.service.impl.MajorServiceImpl;
import com.littlepage.service.impl.TeacherServiceImpl;
import com.littlepage.util.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TeacherListener extends AnalysisEventListener<Teacher> {
    List<Teacher> teachers = new ArrayList<>();
    TeacherService teacherService = new TeacherServiceImpl();
    MajorService majorService = new MajorServiceImpl();

    Logger logger = LoggerFactory.getLogger(StudentListener.class);

    //每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
    private static final int BATCH_COUNT = 5;

    @Override
    public void invoke(Teacher teacher, AnalysisContext context) {
        logger.info(teacher.toString());
        if(teacher.getId() != null) teachers.add(teacher);
        if (teachers.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            teachers.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        logger.info("所有数据解析完成！");
    }
    private void saveData() {
        logger.info(String.valueOf(teachers.size()));
        for (Teacher teacher: teachers) {
            // 设置专业
            if(majorService.selectMajorByName(teacher.getMajor()) == null) {
                Major major = new Major();
                major.setId(0); major.setInfo("");
                major.setMax(0); major.setName(teacher.getMajor());
                majorService.insertMajor(major);
            }
            teacher.setPasswd(Md5Util.getMD5Str(teacher.getPasswd()));
            teacherService.insertTeacher(teacher);
        }
        logger.info("存储数据库成功！");
    }
}
