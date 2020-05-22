package com.littlepage.service;

import com.littlepage.dao.CommonDao;
import com.littlepage.entity.Student;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StudentServiceImpl implements StudentService {
    CommonDao<Student> commonDao = new CommonDao<>();
    @Override
    public List<Student> selectStudents(int start, int count) {
        return commonDao.selectBatch(Student.class, start, count);
    }

    @Override
    public Student selectStudent(int id) {
        Map<String, Object> map = new TreeMap<>();
        map.put("id", id);
        List<Student> list = commonDao.selectEqual("t_student", map, Student.class);
        return  list.size() == 0 ? null: list.get(0);
    }

    @Override
    public boolean insertStudent(Student student) {
        return commonDao.insert(student);
    }

    @Override
    public boolean deleteStudent(int id) {
        return commonDao.delete(id, Student.class);
    }

    @Override
    public List<Student> search(String message) {
        return commonDao.selectLike("t_student", message,Student.class);
    }

    @Override
    public boolean update(Student student) {
        return commonDao.update(student);
    }

    public int makePageList(int pageSize) {
        int size = commonDao.count("t_student");
        return size / pageSize;
    }
}
