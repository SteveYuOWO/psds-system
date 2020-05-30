package com.littlepage.service;

import com.littlepage.dao.CommonDao;
import com.littlepage.entity.Student;
import com.littlepage.entity.Teacher;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TeacherServiceImpl implements TeacherService {
    CommonDao<Teacher> commonDao = new CommonDao<>();

    @Override
    public List<Teacher> selectTeachers(int start, int count) {
        return commonDao.selectBatch(Teacher.class, start, count);
    }

    @Override
    public Teacher selectTeacher(int id) {
        Map<String, Object> map = new TreeMap<>();
        map.put("id", id);
        List<Teacher> list = commonDao.selectEqual("t_teacher", map, Teacher.class);
        return list.size() == 0 ? null: list.get(0);
    }

    @Override
    public boolean insertTeacher(Teacher teacher) {
        return commonDao.insert(teacher);
    }

    @Override
    public boolean deleteTeacher(int id) {
        return commonDao.delete(id, Teacher.class);
    }

    @Override
    public List<Teacher> search(String message) {
        return commonDao.selectLike("t_teacher", message, Teacher.class);
    }

    @Override
    public boolean update(Teacher teacher) {
        return commonDao.update(teacher);
    }

    @Override
    public int makePageList(int pageSize) {
        int size = commonDao.count("t_teacher");
        return size / pageSize;
    }

    @Override
    public List<Teacher> selectTeacherByMajor(String major) {
        Map<String, Object> map = new TreeMap<>();
        map.put("major", major);
        return commonDao.selectEqual("t_teacher", map, Teacher.class);
    }
}
