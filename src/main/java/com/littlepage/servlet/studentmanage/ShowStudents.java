package com.littlepage.servlet.studentmanage;

import com.littlepage.entity.Major;
import com.littlepage.entity.Student;
import com.littlepage.entity.Teacher;
import com.littlepage.service.MajorService;
import com.littlepage.service.StudentService;
import com.littlepage.service.impl.MajorServiceImpl;
import com.littlepage.service.impl.StudentServiceImpl;
import com.littlepage.service.TeacherService;
import com.littlepage.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 显示学生信息
 */
@WebServlet(urlPatterns = {"/manage/admin/showstudents", "/manage/teacher/showstudents"})
public class ShowStudents extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    TeacherService teacherService = new TeacherServiceImpl();
    MajorService majorService = new MajorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        int currentPage = 0;
        if(pageNum != null) currentPage = Integer.parseInt(pageNum);
        majorProcess(req, resp);
        if(req.getSession().getAttribute("type").toString().contains("管理员")) {
            adminShowStudentProcess(currentPage, req, resp);
        } else {
            teacherShowStudentProcess(currentPage, req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * 显示学生
     * 身份为管理员的跳转处理
     * @param currentPage
     * @param req
     * @param resp
     */
    private void adminShowStudentProcess(int currentPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentService.selectStudents(currentPage * 10, 10);
        int pageCount = studentService.makePageList(10);
        req.setAttribute("pageCount", pageCount);
        req.setAttribute("students", students);
        req.getRequestDispatcher("managestudents.jsp").forward(req, resp);
    }

    /**
     * 显示学生
     * 身份为老师的跳转处理
     * @param currentPage
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void teacherShowStudentProcess(int currentPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher = (Teacher) req.getSession().getAttribute("user");
        List<Student> students = teacherService.selectHasChooseStudentsByTeaId(teacher.getId());
        int pageCount = 1;
        req.setAttribute("pageCount", pageCount);
        req.setAttribute("students", students);
        req.getRequestDispatcher("studentschoose.jsp").forward(req, resp);
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
