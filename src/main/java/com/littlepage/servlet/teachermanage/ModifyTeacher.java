package com.littlepage.servlet.teachermanage;

import com.littlepage.entity.Teacher;
import com.littlepage.service.TeacherService;
import com.littlepage.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manage/admin/modifyTeacher")
public class ModifyTeacher extends HttpServlet {
    TeacherService teacherService = new TeacherServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String teaNum = req.getParameter("teaNum");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String major = req.getParameter("major");
        String info = req.getParameter("info");
        String sex = req.getParameter("sex");
        Teacher teacher = teacherService.selectTeacher(id);
        teacher.setId(id); teacher.setTeaNum(teaNum); teacher.setName(name);
        teacher.setEmail(email); teacher.setMajor(major); teacher.setInfo(info);
        if(sex.equals("1")) teacher.setSex("男");
        else teacher.setSex("女");
        boolean success = teacherService.update(teacher);
        if(success) req.getSession().setAttribute("message", "修改成功");
        else req.getSession().setAttribute("message", "修改失败");
        resp.sendRedirect(req.getContextPath() + "/manage/admin/showteachers");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
