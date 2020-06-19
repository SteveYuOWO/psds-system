package com.littlepage.servlet.teachermanage;

import com.littlepage.entity.Major;
import com.littlepage.entity.Teacher;
import com.littlepage.service.MajorService;
import com.littlepage.service.TeacherService;
import com.littlepage.service.impl.MajorServiceImpl;
import com.littlepage.service.impl.TeacherServiceImpl;

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
    MajorService majorService = new MajorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        if(message == null || message.equals("")) {
            resp.sendRedirect("showteachers");
            return;
        }
        List<Teacher> list = teacherService.search(message);
        req.setAttribute("pageCount", 0);
        req.setAttribute("teachers", list);
        majorProcess(req, resp);
        req.getRequestDispatcher("manageteachers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * 放入专业
     * @param req
     * @param resp
     */
    private void majorProcess(HttpServletRequest req, HttpServletResponse resp) {
        List<Major> majors = majorService.selectMajors(0, 100);
        req.setAttribute("majors", majors);
    }
}
