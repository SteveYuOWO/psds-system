package com.littlepage.servlet.studentmanage.admin;

import com.littlepage.service.StudentService;
import com.littlepage.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manage/admin/deleteStudent")
public class DeleteStudent extends HttpServlet {

    StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = -1;
        if(req.getParameter("id") != null) id = Integer.parseInt(req.getParameter("id"));
        if(id != -1) {
            boolean success = studentService.deleteStudent(id);
            if(success) req.getSession().setAttribute("message", "删除成功");
            else req.getSession().setAttribute("message", "删除失败");
        } else req.getSession().setAttribute("message", "删除失败");
        resp.sendRedirect(req.getContextPath() + "/manage/admin/showstudents");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
