package com.littlepage.servlet.choosemanage;

import com.littlepage.entity.DualChoose;
import com.littlepage.entity.Student;
import com.littlepage.entity.Teacher;
import com.littlepage.service.ChooseService;
import com.littlepage.service.ChooseServiceImpl;
import com.littlepage.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/manage/student/hasChooseTeachers")
public class HasChooseTeachers extends HttpServlet {

    ChooseService chooseService = new ChooseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = ((Student)req.getSession().getAttribute("user")).getId();
        List<Teacher> teachers = chooseService.selectDualChooseByStudent(studentId);
        req.setAttribute("teachers", teachers);
        req.getRequestDispatcher("haschooseteacher.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
