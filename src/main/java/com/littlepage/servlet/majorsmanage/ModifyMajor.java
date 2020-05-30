package com.littlepage.servlet.majorsmanage;

import com.alibaba.excel.util.StringUtils;
import com.littlepage.entity.Major;
import com.littlepage.service.MajorService;
import com.littlepage.service.MajorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/manage/admin/modifyMajor")
public class ModifyMajor extends HttpServlet {
    MajorService majorService = new MajorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String maxCapacity = req.getParameter("maxCapacity");
        String info = req.getParameter("info");
        System.out.println(name);
        System.out.println(maxCapacity);
        System.out.println(info);
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(maxCapacity) ||
                StringUtils.isEmpty(info)) {
            req.getSession().setAttribute("message", "输入不能为空");
        } else {
            List<Major> majors = majorService.selectMajorByName(name);
            Major major = majors.get(0);
            major.setMax(Integer.parseInt(maxCapacity));
            major.setInfo(info);
            boolean success = majorService.updateMajor(major);
            if(success) {
                req.getSession().setAttribute("message", "修改成功");
            } else {
                req.getSession().setAttribute("message", "修改失败");
            }
        }
        resp.sendRedirect("showMajors");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
