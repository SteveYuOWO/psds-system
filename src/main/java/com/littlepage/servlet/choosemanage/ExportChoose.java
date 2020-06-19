package com.littlepage.servlet.choosemanage;

import com.alibaba.excel.EasyExcel;
import com.littlepage.entity.FinalTableView;
import com.littlepage.entity.Student;
import com.littlepage.service.FinalConfirmService;
import com.littlepage.service.impl.FinalConfirmServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/manage/admin/exportChoose")
public class ExportChoose extends HttpServlet {
    FinalConfirmService finalConfirmService = new FinalConfirmServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getSession()
        List<FinalTableView> studentList = finalConfirmService.selectManageChoosesAlready();
        ServletOutputStream outputStream = resp.getOutputStream();
        resp.reset();
        resp.setHeader("Content-disposition", "attachment; filename=" + "major.xlsx");
        resp.setContentType("application/ms excel");
        EasyExcel.write(outputStream, FinalTableView.class).sheet("志愿列表").doWrite(studentList);
        outputStream.flush();
        outputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
