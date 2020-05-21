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
    public List<Student> search(Student student) {
        Map<String, Object> map = new TreeMap<>();
        map.put("name", student.getName());
        map.put("sex", student.getSex());
        map.put("stunum", student.getSex());
        map.put("identitynum", student.getSex());
        map.put("email", student.getSex());
        map.put("headpic", student.getSex());
        map.put("major", student.getSex());
        map.put("info", student.getSex());
        map.put("chooseteacher", student.getSex());
        return commonDao.selectLike("t_student", null,Student.class);
    }

    @Override
    public boolean update(Student student) {
        return commonDao.update(student);
    }
}
