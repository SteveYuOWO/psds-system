package com.littlepage.service;

import com.littlepage.dao.CommonDao;
import com.littlepage.entity.Admin;
import com.littlepage.entity.Student;

import java.util.Map;
import java.util.TreeMap;

public class LoginServiceImpl implements LoginService {
    CommonDao<Admin> commonDao = new CommonDao<>();
    CommonDao<Student> commonDao2 = new CommonDao<>();
    @Override
    public boolean loginAdmin(String loginName, String password) {
        Map<String, Object> map = new TreeMap<>();
        map.put("name", loginName);
        map.put("passwd", password);
        return commonDao.selectEqual("t_admin", map, Admin.class).size() != 0;
    }

    @Override
    public boolean loginStudent(String loginName, String password) {
        Map<String, Object> map = new TreeMap<>();
        map.put("stuNum", loginName);
        map.put("passwd", password);
        return commonDao2.selectEqual("t_student", map, Student.class).size() != 0;
    }
}
