package com.littlepage.service;

import com.littlepage.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> selectStudents(int start, int count);

    Student selectStudent(int id);

    boolean insertStudent(Student student);

    boolean deleteStudent(int id);

    boolean update(Student student);

    int makePageList(int pageSize);

    Student selectStudentByStuNum(String loginName);

    List<Student> search(String message, int start, int count);
}
