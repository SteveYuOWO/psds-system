package com.littlepage.servlet.choosemanage;

import com.littlepage.entity.DualChoose;
import com.littlepage.entity.Major;
import com.littlepage.service.ChooseService;
import com.littlepage.service.MajorService;
import com.littlepage.service.StudentService;
import com.littlepage.service.impl.ChooseServiceImpl;
import com.littlepage.service.impl.MajorServiceImpl;
import com.littlepage.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/manage/admin/finalChoose")
public class FinalChoose extends HttpServlet {
    ChooseService dualChooseService = new ChooseServiceImpl();
    MajorService majorService = new MajorServiceImpl();
    StudentService studentService = new StudentServiceImpl();
    ChooseService chooseService = new ChooseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        String teacherId = req.getParameter("teacherId");
        Major major = majorService.selectMajorByName(studentService.selectStudent(Integer.parseInt(studentId)).getMajor());
        Integer maxCount = major.getMax(); //

        Integer cnt = chooseService.selectMajorCount(major.getName());

        System.out.println(maxCount + "   " + cnt);
        if(cnt > maxCount) {
            req.getSession().setAttribute("message", "超过该专业志愿上限");
            resp.sendRedirect("showChooseManage");
            return;
        }
        if(dualChooseService.confirmNullUpdate(Integer.parseInt(studentId), 2)) {
            boolean success =  dualChooseService.updateStatus(Integer.parseInt(studentId), Integer.parseInt(teacherId), 2);
            if(success) req.getSession().setAttribute("message", "选择成功");
            else req.getSession().setAttribute("message", "选择失败");
        } else {
            req.getSession().setAttribute("message", "该学生已经有导师");
        }
        resp.sendRedirect("showChooseManage");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
