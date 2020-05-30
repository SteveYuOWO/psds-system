package com.littlepage.service;

import com.littlepage.entity.Student;
import com.littlepage.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> selectTeachers(int start, int count);

    Teacher selectTeacher(int id);

    boolean insertTeacher(Teacher teacher);

    boolean deleteTeacher(int id);

    List<Teacher> search(String message);

    boolean update(Teacher teacher);

    int makePageList(int pageSize);

    List<Teacher> selectTeacherByMajor(String major);
}
