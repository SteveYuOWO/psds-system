package com.littlepage.servlet.majorsmanage;

import com.littlepage.entity.Major;
import com.littlepage.service.MajorService;
import com.littlepage.service.impl.MajorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/manage/admin/showMajors")
public class ShowMajors extends HttpServlet {
    MajorService majorService = new MajorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        int currentPage = 0;
        if(pageNum != null) currentPage = Integer.parseInt(pageNum);
        List<Major> majors = majorService.selectMajors(currentPage * 10, 10);
        int pageCount = majorService.makePageList(10);
        req.setAttribute("pageCount", pageCount);
        req.setAttribute("majors", majors);
        req.getRequestDispatcher("managemajors.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
