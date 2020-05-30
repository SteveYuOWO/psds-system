package com.littlepage.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.littlepage.entity.Major;
import com.littlepage.entity.Student;
import com.littlepage.service.MajorService;
import com.littlepage.service.MajorServiceImpl;
import com.littlepage.service.StudentService;
import com.littlepage.service.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class StudentListener extends AnalysisEventListener<Student> {
    List<Student> studentList = new ArrayList<>();
    StudentService studentService = new StudentServiceImpl();
    MajorService majorService = new MajorServiceImpl();

    Logger logger = LoggerFactory.getLogger(StudentListener.class);

    //每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
    private static final int BATCH_COUNT = 5;

    @Override
    public void invoke(Student student, AnalysisContext context) {
        System.out.println(student);
        if(student.getId() != null) studentList.add(student);
        if (studentList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            studentList.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        logger.info("所有数据解析完成！");
    }
    private void saveData() {
        logger.info(String.valueOf(studentList.size()));
        for (Student student : studentList) {
            System.out.println(student);
            studentService.insertStudent(student);
        }
        logger.info("存储数据库成功！");
    }
}