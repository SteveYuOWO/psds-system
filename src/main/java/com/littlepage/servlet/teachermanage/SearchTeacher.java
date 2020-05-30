package com.littlepage.servlet.teachermanage;

import com.littlepage.entity.Student;
import com.littlepage.entity.Teacher;
import com.littlepage.service.TeacherService;
import com.littlepage.service.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/manage/admin/searchTeacher",
        "/manage/student/searchTeacher"})
public class SearchTeacher extends HttpServlet {
    TeacherService teacherService = new TeacherServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        if(message == null || message.equals("")) {
            resp.sendRedirect("showteachers");
            return;
        }
        List<Teacher> list = teacherService.search(message);
        req.setAttribute("pageCount", 1);
        req.setAttribute("teachers", list);
        req.getRequestDispatcher("teacherschoose.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
