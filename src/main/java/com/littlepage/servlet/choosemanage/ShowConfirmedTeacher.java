package com.littlepage.servlet.choosemanage;

import com.littlepage.entity.Student;
import com.littlepage.entity.Teacher;
import com.littlepage.service.TeacherService;
import com.littlepage.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/manage/teacher/showConfirmedStudents")
public class ShowConfirmedTeacher extends HttpServlet {
    TeacherService teacherService = new TeacherServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        int currentPage = 0;
        if(pageNum != null) currentPage = Integer.parseInt(pageNum);

        if(req.getSession().getAttribute("type").equals("学院管理员")) {

        } else {
            Teacher teacher = (Teacher) req.getSession().getAttribute("user");
            List<Student> students = teacherService.selectHasConfirmedChooseStudentsByTeaId(teacher.getId());
            int pageCount = 1;
            req.setAttribute("pageCount", pageCount);
            req.setAttribute("students", students);
            req.getRequestDispatcher("studentconfirmedlist.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
