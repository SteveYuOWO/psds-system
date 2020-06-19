package com.littlepage.servlet.adminmanage;

import com.littlepage.entity.Admin;
import com.littlepage.service.AdminService;
import com.littlepage.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/manage/admin/showAdmin")
public class ShowAdmin extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Admin> list = adminService.selectAdmins();
        req.setAttribute("admins", list);
        req.getRequestDispatcher("manageadmin.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
