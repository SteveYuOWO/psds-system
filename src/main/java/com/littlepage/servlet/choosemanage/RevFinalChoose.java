package com.littlepage.servlet.choosemanage;

import com.littlepage.service.ChooseService;
import com.littlepage.service.impl.ChooseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manage/admin/revFinalChoose")
public class RevFinalChoose extends HttpServlet {
    ChooseService dualChooseService = new ChooseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        String teacherId = req.getParameter("teacherId");
        boolean success =  dualChooseService.updateStatus(Integer.parseInt(studentId), Integer.parseInt(teacherId), 1);
        if(success) req.getSession().setAttribute("message", "移除选择成功");
        else req.getSession().setAttribute("message", "选择失败");
        resp.sendRedirect("showChooseManage");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
