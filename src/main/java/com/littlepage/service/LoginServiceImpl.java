package com.littlepage.service;

import com.littlepage.dao.CommonDao;
import com.littlepage.entity.Admin;

import java.util.Map;
import java.util.TreeMap;

public class LoginServiceImpl implements LoginService {
    CommonDao<Admin> commonDao = new CommonDao<>();
    @Override
    public boolean loginAdmin(String loginName, String password) {
        Map<String, Object> map = new TreeMap<>();
        map.put("name", loginName);
        map.put("passwd", password);
        return commonDao.selectEqual("t_admin", map, Admin.class).size() != 0;
    }
}
