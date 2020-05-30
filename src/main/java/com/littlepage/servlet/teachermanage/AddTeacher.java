package com.littlepage.servlet.teachermanage;

import com.alibaba.excel.util.StringUtils;
import com.littlepage.entity.Major;
import com.littlepage.entity.Teacher;
import com.littlepage.service.MajorService;
import com.littlepage.service.MajorServiceImpl;
import com.littlepage.service.TeacherService;
import com.littlepage.service.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manage/admin/addteacher")
public class AddTeacher extends HttpServlet {
    TeacherService teacherService = new TeacherServiceImpl();
    MajorService majorService = new MajorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teaNum = req.getParameter("teaNum");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String major = req.getParameter("major");
        String information = req.getParameter("information");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        if(StringUtils.isEmpty(teaNum) || StringUtils.isEmpty(name) ||
                StringUtils.isEmpty(email) || StringUtils.isEmpty(major) ||
                StringUtils.isEmpty(information) || StringUtils.isEmpty(password) ||
                StringUtils.isEmpty(sex))
            req.getSession().setAttribute("message", "单条录入失败，输入不能为空");
        else {
            Teacher teacher = new Teacher();
            teacher.setId(0); teacher.setTeaNum(teaNum); teacher.setMajor(major);
            teacher.setName(name); teacher.setEmail(email); teacher.setInfo(information);
            teacher.setPasswd(password); teacher.setSex(sex.equals("1") ? "男": "女");
            if(majorService.selectMajorByName(major).size() == 0) {
                Major tmp = new Major();
                tmp.setId(0); tmp.setInfo("");
                tmp.setMax(0); tmp.setName(teacher.getMajor());
                majorService.insertMajor(tmp);
            }
            teacherService.insertTeacher(teacher);
            req.getSession().setAttribute("message", "单条录入成功");
        }
        resp.sendRedirect(req.getContextPath() + "/manage/admin/showteachers");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
