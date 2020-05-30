package com.littlepage.servlet.login;

import com.littlepage.entity.Student;
import com.littlepage.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 登录处理
 */
@WebServlet(urlPatterns = "/loginProcess")
public class LoginProcess extends HttpServlet {
    LoginService loginService = new LoginServiceImpl();
    StudentService studentService = new StudentServiceImpl();
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginName = req.getParameter("loginName");
        String password = req.getParameter("password");
        String type = req.getSession().getAttribute("loginType") == null ? "student": req.getSession().getAttribute("loginType").toString();
        String remember = req.getParameter("remember");
        // 记住密码
        Cookie loginNameCookie = new Cookie("loginName", loginName.replace(" ", "-"));
        Cookie passwordCookie = new Cookie("password", password.replace(" ", "-"));

        logger.info(loginName + password + type);
        if(!(remember != null && remember.equals("on"))) {
            loginNameCookie.setMaxAge(0);
            passwordCookie.setMaxAge(0);
            req.getSession().setAttribute("remember", "");
        } else req.getSession().setAttribute("remember", "checked");
        resp.addCookie(loginNameCookie);
        resp.addCookie(passwordCookie);
        // 路径
        if(type.equals("admin")) {
            boolean success = loginService.loginAdmin(loginName, password);
            if(success) {
                req.getSession().setAttribute("user", loginName);
                req.getSession().setAttribute("message", "管理员" + loginName + "登录成功");
                req.getSession().setAttribute("type", "学院管理员");
                req.getSession().setAttribute("username", loginName);
                resp.sendRedirect("manage/admin/showstudents");
            } else {
                // 记住密码的取用
                req.getSession().setAttribute("wrongMsg", "用户名或密码错误");
                resp.sendRedirect("login?type=admin");
            }
        } else if(type.equals("student")) {
            System.out.println("学生");
            boolean success = loginService.loginStudent(loginName, password);
            if(success) {
                Student student = studentService.selectStudentByStuNum(loginName);
                req.getSession().setAttribute("user", student);
                req.getSession().setAttribute("message", "学生" + student.getName() + "登录成功");
                req.getSession().setAttribute("type", "学生");
                req.getSession().setAttribute("username", student.getName());
                resp.sendRedirect("manage/student/showteachers");
            } else {
                // 记住密码的取用
                req.getSession().setAttribute("wrongMsg", "用户名或密码错误");
                resp.sendRedirect("login?type=student");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
