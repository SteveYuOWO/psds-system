package com.littlepage.service.impl;

import com.littlepage.dao.CommonDao;
import com.littlepage.entity.Admin;
import com.littlepage.entity.Root;
import com.littlepage.entity.Student;
import com.littlepage.entity.Teacher;
import com.littlepage.service.LoginService;

import java.util.Map;
import java.util.TreeMap;

public class LoginServiceImpl implements LoginService {
    CommonDao<Admin> adminDao = new CommonDao<>();
    CommonDao<Student> studentDao = new CommonDao<>();
    CommonDao<Teacher> teacherDao = new CommonDao<>();
    CommonDao<Root> rootDao = new CommonDao<>();

    @Override
    public boolean loginAdmin(String loginName, String password) {
        Map<String, Object> map = new TreeMap<>();
        map.put("name", loginName);
        map.put("passwd", password);
        return adminDao.selectEqual("t_admin", map, Admin.class).size() != 0;
    }

    @Override
    public boolean loginStudent(String loginName, String password) {
        Map<String, Object> map = new TreeMap<>();
        map.put("stuNum", loginName);
        map.put("passwd", password);
        return studentDao.selectEqual("t_student", map, Student.class).size() != 0;
    }

    @Override
    public boolean loginTeacher(String loginName, String password) {
        Map<String, Object> map = new TreeMap<>();
        map.put("teaNum", loginName);
        map.put("passwd", password);
        return teacherDao.selectEqual("t_teacher", map, Teacher.class).size() != 0;
    }

    @Override
    public boolean loginRootAdmin(String loginName, String password) {
        Map<String, Object> map = new TreeMap<>();
        map.put("name", loginName);
        map.put("passwd", password);
        return rootDao.selectEqual("t_root", map, Root.class).size() != 0;
    }
}
