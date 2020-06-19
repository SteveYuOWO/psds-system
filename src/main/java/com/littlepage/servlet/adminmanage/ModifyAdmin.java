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

@WebServlet(urlPatterns = "/manage/admin/modifyAdmin")
public class ModifyAdmin extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        Admin admin = adminService.selectAdminById(id);
        admin.setName(name);
        admin.setSex(sex);
        boolean success = adminService.updateAdmin(admin);
        if(success) {
            req.getSession().setAttribute("message", "修改成功");
        } else {
            req.getSession().setAttribute("message", "修改失败");
        }
        req.getRequestDispatcher("showAdmin").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
