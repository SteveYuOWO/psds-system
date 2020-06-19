package com.littlepage.servlet.teachermanage;

import com.alibaba.excel.util.StringUtils;
import com.littlepage.entity.Teacher;
import com.littlepage.service.TeacherService;
import com.littlepage.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manage/teacher/modifyInfoProcess")
public class ModifyPersonalInfoProcess extends HttpServlet {
    TeacherService teacherService = new TeacherServiceImpl();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = req.getParameter("info");
        String major = req.getParameter("major");
        String email = req.getParameter("email");
//        System.out.println(info + major + email);
        if(StringUtils.isEmpty(info) || StringUtils.isEmpty(major) || StringUtils.isEmpty(email)) {
            req.getSession().setAttribute("message", "输入不能为空");
        } else {
            // 不为空执行更新学生信息
            Teacher teacher = (Teacher) req.getSession().getAttribute("user");
            teacher.setInfo(info); teacher.setMajor(major); teacher.setEmail(email);
            boolean success = teacherService.update(teacher);
            if(success) {
                req.getSession().setAttribute("user", teacher);
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
