package com.littlepage.servlet.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 登录界面
 */
@WebServlet(name = "login", urlPatterns = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        req.setAttribute("type", type);
        // session
        req.getSession().setAttribute("loginType", type);
        if("student".equals(type)) req.setAttribute("name", "学生");
        else if("teacher".equals(type)) req.setAttribute("name", "教师");
        else req.setAttribute("name", "管理员");
        // 记住密码的取用
        String loginName = "", password = "";
        for (Cookie cookie : req.getCookies()) {
            if(cookie.getName().equals("loginName")) loginName = cookie.getValue().replace("-", " ");
            if(cookie.getName().equals("password")) password = cookie.getValue().replace("-", " ");
        }
        req.setAttribute("loginName", loginName);
        req.setAttribute("password", password);
        if(req.getSession().getAttribute("wrongMsg") != null) {
            req.setAttribute("wrongMsg", req.getSession().getAttribute("wrongMsg"));
            req.getSession().removeAttribute("wrongMsg");
        }
        // 跳转
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
