package com.littlepage.service.impl;

import com.littlepage.dao.CommonDao;
import com.littlepage.entity.Student;
import com.littlepage.entity.Teacher;
import com.littlepage.service.StudentService;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StudentServiceImpl implements StudentService {
    CommonDao<Student> studentDao = new CommonDao<>();
    CommonDao<Teacher> teacherDao = new CommonDao<>();
    @Override
    public List<Student> selectStudents(int start, int count) {
        return studentDao.selectBatch(Student.class, start, count);
    }

    @Override
    public Student selectStudent(int id) {
        Map<String, Object> map = new TreeMap<>();
        map.put("id", id);
        List<Student> list = studentDao.selectEqual("t_student", map, Student.class);
        return  list.size() == 0 ? null: list.get(0);
    }

    @Override
    public boolean insertStudent(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentDao.delete(id, Student.class);
    }


    @Override
    public boolean update(Student student) {
        return studentDao.update(student);
    }

    public int makePageList(int pageSize) {
        int size = studentDao.count("t_student");
        return size / pageSize;
    }

    @Override
    public Student selectStudentByStuNum(String stuNum) {
        Map<String, Object> map = new TreeMap<>();
        map.put("stuNum", stuNum);
        List<Student> list = studentDao.selectEqual("t_student", map, Student.class);
        return list.size() == 0 ? null: list.get(0);
    }

    @Override
    public List<Student> search(String message, int start, int count) {
        return studentDao.selectLike("t_student", message,Student.class, start, count);
    }
}
