package com.littlepage.servlet.login;

import com.littlepage.util.SystemLogUtil;
import com.littlepage.util.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        SystemLogUtil.systemLogProcess(req.getRemoteAddr(),
                session.getAttribute("username").toString(),
                session.getAttribute("type").toString(),
                TimeUtil.now(),
                "注销登录");
        session.removeAttribute("user");
        session.removeAttribute("type");
        session.removeAttribute("username");
        resp.sendRedirect(req.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
