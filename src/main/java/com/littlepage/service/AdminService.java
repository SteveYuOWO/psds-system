package com.littlepage.service;

import com.littlepage.entity.Admin;

import java.util.List;

public interface AdminService {
    Admin selectAdminByLoginName(String loginName);

    List<Admin> selectAdmins();

    boolean insertAdmin(Admin admin);

    boolean deleteById(Integer id);

    boolean updateAdmin(Admin admin);

    Admin selectAdminById(String id);
}
