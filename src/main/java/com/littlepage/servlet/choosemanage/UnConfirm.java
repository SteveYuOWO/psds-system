package com.littlepage.servlet.choosemanage;

import com.littlepage.entity.Teacher;
import com.littlepage.service.ChooseService;
import com.littlepage.service.impl.ChooseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manage/teacher/teacherUnconfirm")
public class UnConfirm extends HttpServlet {
    ChooseService chooseService = new ChooseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer studentId = Integer.parseInt(req.getParameter("id"));
        Integer teacherId = ((Teacher) req.getSession().getAttribute("user")).getId();
        boolean success = chooseService.updateStatus(studentId, teacherId, 0);
        if(success) {
            req.setAttribute("message", "取消选择成功");
        } else {
            req.setAttribute("message", "取消选择失败");
        }
        resp.sendRedirect("showConfirmedStudents");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
