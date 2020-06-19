package com.littlepage.servlet.choosemanage;

import com.littlepage.entity.FinalTableView;
import com.littlepage.service.FinalConfirmService;
import com.littlepage.service.impl.FinalConfirmServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/manage/admin/showChooseManage")
public class ShowChooseManage extends HttpServlet {
    FinalConfirmService finalConfirmService = new FinalConfirmServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FinalTableView> notFinalTableViews = finalConfirmService.selectManageChoosesNotFinal();
        List<FinalTableView> alreadyFinalTableViews = finalConfirmService.selectManageChoosesAlready();
        req.setAttribute("notFinalTableView", notFinalTableViews);
        req.setAttribute("alreadyFinalTableViews", alreadyFinalTableViews);
        req.getRequestDispatcher("managechoose.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
