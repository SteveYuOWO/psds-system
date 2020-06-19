package com.littlepage.servlet.adminmanage;

import com.littlepage.entity.Admin;
import com.littlepage.service.AdminService;
import com.littlepage.service.impl.AdminServiceImpl;
import com.littlepage.util.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manage/admin/addAdmin")
public class AddAdmin extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String password = req.getParameter("password");
        Admin admin = new Admin(0, name, sex, Md5Util.getMD5Str(password));
        boolean success = adminService.insertAdmin(admin);
        if(success) {
            req.getSession().setAttribute("message", "添加成功");
        } else {
            req.getSession().setAttribute("message", "添加失败");
        }
        resp.sendRedirect("showAdmin");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
