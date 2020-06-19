package com.littlepage.service;

import com.littlepage.entity.DualChoose;
import com.littlepage.entity.Teacher;

import java.util.List;

public interface ChooseService {
    boolean insertDualChoose(int teacherId, int studentId);

    int countStudentChooseNum(int studentId);

    List<Teacher> selectTeachersByStudent(int studentId);

    List<DualChoose> selectDualChooseByStudent(int studentId);

    boolean deleteDualChoose(int teacherId, int studentId);

    boolean updateStatus(int studentId, int teacherId, int status);

    Integer selectMajorCount(String name);

    boolean confirmNullUpdate(int parseInt, int parseInt1, int i);

    boolean confirmNullUpdate(int studentId, int status);
}
