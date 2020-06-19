package com.littlepage.servlet.choosemanage;

import com.littlepage.entity.DualChoose;
import com.littlepage.entity.Student;
import com.littlepage.entity.Teacher;
import com.littlepage.service.ChooseService;
import com.littlepage.service.impl.ChooseServiceImpl;
import com.littlepage.service.TeacherService;
import com.littlepage.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/manage/student/hasChooseTeachers")
public class HasChooseTeachers extends HttpServlet {

    ChooseService chooseService = new ChooseServiceImpl();

    TeacherService teacherService = new TeacherServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = ((Student)req.getSession().getAttribute("user")).getId();
        List<DualChoose> dualChooses = chooseService.selectDualChooseByStudent(studentId);
        /**
         * teachers分为3个数组存
         */
        List<Teacher> notChooseTeachers = new ArrayList<>();
        List<Teacher> hasConfirmedTeachers = new ArrayList<>();
        List<Teacher> finalConfirmed = new ArrayList<>();

        dualChooses.forEach(dualChoose -> {
            if(dualChoose.getStatus() == 0) notChooseTeachers.add(teacherService.selectTeacherByTeaId(dualChoose.getTeacherId()));
            else if(dualChoose.getStatus() == 1) hasConfirmedTeachers.add(teacherService.selectTeacherByTeaId(dualChoose.getTeacherId()));
            else finalConfirmed.add(teacherService.selectTeacherByTeaId(dualChoose.getTeacherId()));
        });

        req.setAttribute("notChooseTeachers", notChooseTeachers);
        req.setAttribute("hasConfirmedTeachers", hasConfirmedTeachers);
        req.setAttribute("finalConfirmed", finalConfirmed);
        req.getRequestDispatcher("haschooseteacher.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
