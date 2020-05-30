package com.littlepage.servlet.studentmanage;

import com.littlepage.entity.Student;
import com.littlepage.service.StudentService;
import com.littlepage.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 搜索学生
 */
@WebServlet(urlPatterns = "/manage/admin/searchStudent")
public class searchStudent extends HttpServlet {

    StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        if(message == null || message.equals("")) {
            resp.sendRedirect("showstudents");
            return;
        }
        List<Student> list = studentService.search(message);
        req.setAttribute("pageCount", 1);
        req.setAttribute("students", list);
        req.getRequestDispatcher("managestudents.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
