package com.littlepage.servlet.login;

import com.littlepage.service.LoginService;
import com.littlepage.service.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginProcess")
public class LoginProcess extends HttpServlet {
    LoginService loginService = new LoginServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginName = req.getParameter("loginName");
        String password = req.getParameter("password");
        String type = req.getSession().getAttribute("loginType") == null ? "student": req.getSession().getAttribute("loginType").toString();
        String remember = req.getParameter("remember");
        // 记住密码
        Cookie loginNameCookie = new Cookie("loginName", loginName.replace(" ", "-"));
        Cookie passwordCookie = new Cookie("password", password.replace(" ", "-"));
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
                resp.sendRedirect("manage/admin/showstudents");
            } else {
                // 记住密码的取用
                req.getSession().setAttribute("wrongMsg", "用户名或密码错误");
                resp.sendRedirect("login?type=admin");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
