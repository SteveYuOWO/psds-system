package com.littlepage.servlet.studentmanage;

import com.littlepage.entity.Student;
import com.littlepage.service.StudentService;
import com.littlepage.service.impl.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 修改学生信息
 */
@WebServlet(urlPatterns = "/manage/admin/modifyStudent")
public class ModifyStudent extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(ModifyStudent.class);

    StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String stuNum = req.getParameter("stuNum");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String major = req.getParameter("major");
        String info = req.getParameter("info");
        String sex = req.getParameter("sex");
        Student student = studentService.selectStudent(id);
        student.setId(id); student.setStuNum(stuNum); student.setName(name);
        student.setEmail(email); student.setMajor(major); student.setInfo(info);
        if(sex.equals("1")) student.setSex("男");
        else student.setSex("女");
        boolean success = studentService.update(student);
        if(success) req.getSession().setAttribute("message", "修改成功");
        else req.getSession().setAttribute("message", "修改失败");
        logger.info(student.toString());
        resp.sendRedirect(req.getContextPath() + "/manage/admin/showstudents");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
