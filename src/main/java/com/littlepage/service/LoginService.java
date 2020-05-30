package com.littlepage.service;

public interface LoginService {
    boolean loginAdmin(String loginName, String password);

    boolean loginStudent(String loginName, String password);
}
