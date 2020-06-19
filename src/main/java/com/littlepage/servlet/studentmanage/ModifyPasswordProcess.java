package com.littlepage.servlet.studentmanage;

import com.alibaba.excel.util.StringUtils;
import com.littlepage.entity.Student;
import com.littlepage.service.StudentService;
import com.littlepage.service.impl.StudentServiceImpl;
import com.littlepage.util.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manage/student/modifyPasswordProcess")
public class ModifyPasswordProcess extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        String repeatPassword = req.getParameter("repeatPassword");
        if(StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword) ||
                StringUtils.isEmpty(repeatPassword)) {
            req.getSession().setAttribute("message", "输入不能为空");
        } else if(newPassword.equals(repeatPassword)) {
            Student student = (Student)req.getSession().getAttribute("user");
            if(!Md5Util.getMD5Str(oldPassword).equals(student.getPasswd())) {
                req.getSession().setAttribute("message", "旧密码输入错误");
            } else {
                student.setPasswd(Md5Util.getMD5Str(newPassword));
                boolean success = studentService.update(student);
                if(success) req.getSession().setAttribute("message", "密码修改成功");
                else req.getSession().setAttribute("message", "密码修改失败");
            }
        } else {
            req.getSession().setAttribute("message", "两次密码不一致");
        }
        req.getRequestDispatcher("modifypassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
