package com.littlepage.service;

import com.littlepage.entity.DualChoose;
import com.littlepage.entity.Teacher;

import java.util.List;

public interface ChooseService {
    boolean insertDualChoose(int teacherId, int studentId);

    int countStudentChooseNum(int studentId);

    List<Teacher> selectDualChooseByStudent(int studentId);
}
