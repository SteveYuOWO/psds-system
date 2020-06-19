package com.littlepage.servlet.adminmanage;

import com.alibaba.excel.util.StringUtils;
import com.littlepage.service.AdminService;
import com.littlepage.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manage/admin/deleteAdmin")
public class DeleteAdmin extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        boolean success = false;
        if(id != null && id.matches("\\d+")) {
            success = adminService.deleteById(Integer.parseInt(id));
        }
        if(success) {
            req.getSession().setAttribute("message", "删除成功");
        } else {
            req.getSession().setAttribute("message", "删除失败");
        }
        req.getRequestDispatcher("showAdmin").forward(req, resp);
    }
}
