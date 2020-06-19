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

@WebServlet(urlPatterns = "/manage/teacher/teacherConfirmChoose")
public class TeacherConfirmChoose extends HttpServlet {
    ChooseService chooseService = new ChooseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int studentId = Integer.parseInt(req.getParameter("id"));
        int teacherId = ((Teacher)req.getSession().getAttribute("user")).getId();
        boolean success = chooseService.updateStatus(studentId, teacherId, 1);
        if(success) req.getSession().setAttribute("message", "选择学生成功，请等待管理员的最终确认");
        else req.getSession().setAttribute("message", "选择学生失败");
        resp.sendRedirect("showstudents");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
