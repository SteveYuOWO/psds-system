package com.littlepage.service.impl;

import com.littlepage.dao.CommonDao;
import com.littlepage.entity.DualChoose;
import com.littlepage.entity.FinalTableView;
import com.littlepage.entity.Student;
import com.littlepage.entity.Teacher;
import com.littlepage.service.ChooseService;
import com.littlepage.service.FinalConfirmService;
import com.littlepage.service.StudentService;
import com.littlepage.service.TeacherService;

import java.util.ArrayList;
import java.util.List;

public class FinalConfirmServiceImpl implements FinalConfirmService {
    CommonDao<DualChoose> dualChooseCommonDao = new CommonDao<>();

    StudentService studentService = new StudentServiceImpl();
    TeacherService teacherService = new TeacherServiceImpl();

    /**
     * 选择未最终选择的
     * @return
     */
    @Override
    public List<FinalTableView> selectManageChoosesNotFinal() {
        List<FinalTableView> list = new ArrayList<>();
        List<DualChoose> dualChooses = dualChooseCommonDao.selectBatch(DualChoose.class, 0, 10000);
        dualChooses.forEach(dualChoose -> {
            if(dualChoose.getStatus() == 1) {
                Student student = studentService.selectStudent(dualChoose.getStudentId());
                Teacher teacher = teacherService.selectTeacherByTeaId(dualChoose.getTeacherId());
                FinalTableView finalTableView = new FinalTableView();
                finalTableView.setStudentId(student.getId());
                finalTableView.setStudentName(student.getName());
                finalTableView.setTeacherId(teacher.getId());
                finalTableView.setTeacherName(teacher.getName());
                finalTableView.setTeacherNum(teacher.getTeaNum());
                finalTableView.setStudentNum(student.getStuNum());
                finalTableView.setMajor(student.getMajor());
                list.add(finalTableView);
            }
        });
        return list;
    }

    @Override
    public List<FinalTableView> selectManageChoosesAlready() {
        List<FinalTableView> list = new ArrayList<>();
        List<DualChoose> dualChooses = dualChooseCommonDao.selectBatch(DualChoose.class, 0, 10000);
        dualChooses.forEach(dualChoose -> {
            if(dualChoose.getStatus() == 2) {
                Student student = studentService.selectStudent(dualChoose.getStudentId());
                Teacher teacher = teacherService.selectTeacherByTeaId(dualChoose.getTeacherId());
                FinalTableView finalTableView = new FinalTableView();
                finalTableView.setStudentId(student.getId());
                finalTableView.setStudentName(student.getName());
                finalTableView.setTeacherId(teacher.getId());
                finalTableView.setTeacherName(teacher.getName());
                finalTableView.setStudentNum(student.getStuNum());
                finalTableView.setTeacherNum(teacher.getTeaNum());
                finalTableView.setMajor(student.getMajor());
                list.add(finalTableView);
            }
        });
        return list;
    }

    @Override
    public List<FinalTableView> selectAll() {
        List<FinalTableView> list = new ArrayList<>();
        List<DualChoose> dualChooses = dualChooseCommonDao.selectBatch(DualChoose.class, 0, 10000);
        dualChooses.forEach(dualChoose -> {
            Student student = studentService.selectStudent(dualChoose.getStudentId());
            Teacher teacher = teacherService.selectTeacherByTeaId(dualChoose.getTeacherId());
            FinalTableView finalTableView = new FinalTableView();
            finalTableView.setStudentId(student.getId());
            finalTableView.setStudentName(student.getName());
            finalTableView.setTeacherId(teacher.getId());
            finalTableView.setTeacherName(teacher.getName());
            finalTableView.setTeacherNum(teacher.getTeaNum());
            finalTableView.setStudentNum(student.getStuNum());
            finalTableView.setMajor(student.getMajor());
            list.add(finalTableView);
        });
        return list;
    }
}
