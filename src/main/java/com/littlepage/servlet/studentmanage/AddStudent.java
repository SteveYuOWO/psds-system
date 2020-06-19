package com.littlepage.servlet.studentmanage;

import com.alibaba.excel.util.StringUtils;
import com.littlepage.entity.Student;
import com.littlepage.service.StudentService;
import com.littlepage.service.impl.StudentServiceImpl;
import com.littlepage.util.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 增加单个学生
 */
@WebServlet(urlPatterns = "/manage/admin/addstudent")
public class AddStudent extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuNum = req.getParameter("stuNum");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String major = req.getParameter("major");
        String information = req.getParameter("information");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        if(StringUtils.isEmpty(stuNum) || StringUtils.isEmpty(name) ||
                StringUtils.isEmpty(email) || StringUtils.isEmpty(major) ||
                StringUtils.isEmpty(information) || StringUtils.isEmpty(password) ||
                StringUtils.isEmpty(sex))
                req.getSession().setAttribute("message", "单条录入失败，输入不能为空");
        else {
            Student student = new Student();
            student.setId(0); student.setStuNum(stuNum); student.setMajor(major);
            student.setName(name); student.setEmail(email); student.setInfo(information);
            student.setPasswd(Md5Util.getMD5Str(password)); student.setSex(sex.equals("1") ? "男": "女");
            studentService.insertStudent(student);
            req.getSession().setAttribute("message", "单条录入成功");
        }
        resp.sendRedirect(req.getContextPath() + "/manage/admin/showstudents");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
