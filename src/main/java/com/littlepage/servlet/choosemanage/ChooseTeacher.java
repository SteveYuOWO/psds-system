package com.littlepage.servlet.choosemanage;

import com.littlepage.entity.Student;
import com.littlepage.service.ChooseService;
import com.littlepage.service.ChooseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manage/student/chooseTeacher")
public class ChooseTeacher extends HttpServlet {
    ChooseService chooseService = new ChooseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int teacherId = Integer.parseInt(req.getParameter("id"));
        int studentId = ((Student)req.getSession().getAttribute("user")).getId();

        /**
         * 查看学生的志愿数量
         */
        int chooseCnt = chooseService.countStudentChooseNum(studentId);
        if(chooseCnt >= 3) {
            req.getSession().setAttribute("message", "您已选择3个志愿，不得选择超过3个志愿");
            resp.sendRedirect("showteachers");
            return;
        }
        /**
         * 进行插入
         */
        boolean success = chooseService.insertDualChoose(teacherId, studentId);
        if(success) {
            req.getSession().setAttribute("message", "选择成功，请等待老师的选择");
        } else {
            req.getSession().setAttribute("message", "不能重复选择同样的老师");
        }
        resp.sendRedirect("showteachers");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
