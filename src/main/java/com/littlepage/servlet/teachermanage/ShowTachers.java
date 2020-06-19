package com.littlepage.servlet.teachermanage;

import com.littlepage.entity.Major;
import com.littlepage.entity.Student;
import com.littlepage.entity.Teacher;
import com.littlepage.service.ChooseService;
import com.littlepage.service.MajorService;
import com.littlepage.service.impl.ChooseServiceImpl;
import com.littlepage.service.TeacherService;
import com.littlepage.service.impl.MajorServiceImpl;
import com.littlepage.service.impl.TeacherServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 显示教师信息
 */
@WebServlet(urlPatterns = {"/manage/admin/showteachers", "/manage/student/showteachers"})
public class ShowTachers extends HttpServlet {
    TeacherService teacherService = new TeacherServiceImpl();
    ChooseService chooseService = new ChooseServiceImpl();
    MajorService majorService = new MajorServiceImpl();

    Logger logger = LoggerFactory.getLogger(ShowTachers.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 预处理相关信息
        List<Teacher> teachers = beforeShowTeachersProcess(req, resp);
        majorProcess(req, resp);
        if(req.getSession().getAttribute("type").equals("学生")) {
            // 为学生时登录的处理
            showTechersStudentProcess(teachers, req, resp);
        } else if(req.getSession().getAttribute("type").toString().contains("管理员")) {
            // 为管理员登录时的处理（包含Root和学院级别）
            req.getRequestDispatcher("manageteachers.jsp").forward(req, resp);
        }
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

    /**
     * 预处理教师信息等
     * @param req
     * @param resp
     * @return
     */
    private List<Teacher> beforeShowTeachersProcess(HttpServletRequest req, HttpServletResponse resp) {
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
        return teachers;
    }

    /**
     * 学生相关的处理
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void showTechersStudentProcess(List<Teacher> teachers, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student user = (Student)req.getSession().getAttribute("user");
        // 移除已经被选择的
        List<Teacher> supposeRemovedTeachers = chooseService.selectTeachersByStudent(((Student)req.getSession().getAttribute("user")).getId());
        List<Teacher> ans = new ArrayList<>();
        for (int i = 0; i < teachers.size(); i++) {
            boolean add = true;
            for (Teacher supposeRemovedTeacher : supposeRemovedTeachers) {
                if(supposeRemovedTeacher.getId().equals(teachers.get(i).getId())) {
                    add = false;
                    break;
                }
            }
            if(add && user.getMajor().equals(teachers.get(i).getMajor())) ans.add(teachers.get(i));
        }
        req.setAttribute("teachers", ans);
        req.getRequestDispatcher("teacherschoose.jsp").forward(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
