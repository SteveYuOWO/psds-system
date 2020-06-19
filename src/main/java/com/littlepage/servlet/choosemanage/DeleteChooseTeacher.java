package com.littlepage.servlet.choosemanage;

import com.littlepage.entity.Student;
import com.littlepage.service.ChooseService;
import com.littlepage.service.impl.ChooseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manage/student/deleteChooseTeacher")
public class DeleteChooseTeacher extends HttpServlet {
    ChooseService chooseService = new ChooseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int teacherId = Integer.parseInt(req.getParameter("id"));
        int studentId = ((Student)req.getSession().getAttribute("user")).getId();

        /**
         * 进行删除
         */
        boolean success = chooseService.deleteDualChoose(teacherId, studentId);
        if(success) {
            req.getSession().setAttribute("message", "删除志愿成功");
        } else {
            req.getSession().setAttribute("message", "删除志愿失败");
        }
        resp.sendRedirect("hasChooseTeachers");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
