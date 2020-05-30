package com.littlepage.servlet.teachermanage;

import com.littlepage.entity.Student;
import com.littlepage.entity.Teacher;
import com.littlepage.service.TeacherService;
import com.littlepage.service.TeacherServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 显示教师信息
 */
@WebServlet(urlPatterns = {"/manage/admin/showteachers", "/manage/student/showteachers"})
public class ShowTachers extends HttpServlet {
    TeacherService teacherService = new TeacherServiceImpl();

    Logger logger = LoggerFactory.getLogger(ShowTachers.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        int currentPage = 0;
        if(pageNum != null) currentPage = Integer.parseInt(pageNum);
        List<Teacher> teachers = null;
        teachers = teacherService.selectTeachers(currentPage * 10, 10);
        int pageCount = teacherService.makePageList(10);
        for (Teacher teacher : teachers) {
            logger.info(teacher.toString());
        }
        req.setAttribute("pageCount", pageCount);
        req.setAttribute("teachers", teachers);
        if(req.getSession().getAttribute("type").equals("学生")) {
            req.getRequestDispatcher("teacherschoose.jsp").forward(req, resp);
        } else if(req.getSession().getAttribute("type").equals("学院管理员")) {
            req.getRequestDispatcher("manageteachers.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
