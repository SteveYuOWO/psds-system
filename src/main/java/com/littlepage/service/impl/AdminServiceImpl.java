package com.littlepage.service.impl;

import com.littlepage.dao.CommonDao;
import com.littlepage.entity.Admin;
import com.littlepage.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    CommonDao<Admin> commonDao = new CommonDao<>();

    @Override
    public Admin selectAdminByLoginName(String loginName) {
        List<Admin> admins = commonDao.selectByStringParam("t_admin", "name", loginName, Admin.class);
        return admins.size() == 0 ? null: admins.get(0);
    }

    @Override
    public List<Admin> selectAdmins() {
        return commonDao.selectBatch(Admin.class, 0, 10000);
    }

    @Override
    public boolean insertAdmin(Admin admin) {
        return commonDao.insert(admin);
    }

    @Override
    public boolean deleteById(Integer id) {
        return commonDao.delete(id, Admin.class);
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        return commonDao.update(admin);
    }

    @Override
    public Admin selectAdminById(String id) {
        List<Admin> admins = commonDao.selectByStringParam("t_admin", "id", id, Admin.class);
        return admins.size() == 0 ? null: admins.get(0);
    }
}
