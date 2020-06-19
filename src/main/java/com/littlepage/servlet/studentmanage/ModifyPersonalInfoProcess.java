package com.littlepage.servlet.studentmanage;

import com.alibaba.excel.util.StringUtils;
import com.littlepage.entity.Student;
import com.littlepage.service.StudentService;
import com.littlepage.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manage/student/modifyInfoProcess")
public class ModifyPersonalInfoProcess extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = req.getParameter("info");
        String major = req.getParameter("major");
        String email = req.getParameter("email");
        if(StringUtils.isEmpty(info) || StringUtils.isEmpty(major) || StringUtils.isEmpty(email)) {
            req.getSession().setAttribute("message", "输入不能为空");
        } else {
            // 不为空执行更新学生信息
            Student student = (Student) req.getSession().getAttribute("user");
            student.setInfo(info); student.setMajor(major); student.setEmail(email);
            boolean success = studentService.update(student);
            if(success) {
                req.getSession().setAttribute("user", student);
                req.getSession().setAttribute("message", "更新个人信息成功");
            }
        }
        resp.sendRedirect("modifyInfo");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
