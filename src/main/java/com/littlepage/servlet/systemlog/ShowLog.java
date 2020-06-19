package com.littlepage.servlet.systemlog;

import com.littlepage.entity.Student;
import com.littlepage.entity.SystemLog;
import com.littlepage.service.SystemLogService;
import com.littlepage.service.impl.SystemLogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/manage/admin/showLogs")
public class ShowLog extends HttpServlet {
    SystemLogService systemLogService = new SystemLogServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        int currentPage = 0;
        if(pageNum != null) currentPage = Integer.parseInt(pageNum);
        List<SystemLog> logs = systemLogService.showLogs(currentPage * 10, 10);
        int pageCount = systemLogService.makePageList(10);
        req.setAttribute("pageCount", pageCount);
        req.setAttribute("logs", logs);
        req.getRequestDispatcher("showlogs.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
