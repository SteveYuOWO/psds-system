package com.littlepage.servlet.studentmanage;

import com.littlepage.entity.Major;
import com.littlepage.entity.Student;
import com.littlepage.service.MajorService;
import com.littlepage.service.StudentService;
import com.littlepage.service.impl.MajorServiceImpl;
import com.littlepage.service.impl.StudentServiceImpl;

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
public class SearchStudent extends HttpServlet {

    StudentService studentService = new StudentServiceImpl();
    MajorService majorService = new MajorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        if(message == null || message.equals("")) {
            resp.sendRedirect("showstudents");
            return;
        }
        String pageNum = req.getParameter("pageNum");
        int currentPage = 0;
        if(pageNum != null) currentPage = Integer.parseInt(pageNum);


//        List<Student> students = studentService.selectStudents(currentPage * 10, 10);
        List<Student> list = studentService.search(message, currentPage * 10, 100000);
//        int pageCount = studentService.makePageList(10);
        req.setAttribute("pageCount", 0);
        req.setAttribute("students", list);
        majorProcess(req, resp);
        req.getRequestDispatcher("managestudents.jsp").forward(req, resp);
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
