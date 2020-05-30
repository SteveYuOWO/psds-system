package com.littlepage.servlet.teachermanage;

import com.alibaba.excel.EasyExcel;
import com.littlepage.entity.Student;
import com.littlepage.entity.Teacher;
import com.littlepage.service.StudentService;
import com.littlepage.service.StudentServiceImpl;
import com.littlepage.service.TeacherService;
import com.littlepage.service.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 导出Excel
 */
@WebServlet(urlPatterns = "/manage/admin/exportTeachers")
public class ExportTeacher extends HttpServlet {
    TeacherService teacherService = new TeacherServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Teacher> teachers = teacherService.selectTeachers(0, Integer.MAX_VALUE);
        ServletOutputStream outputStream = resp.getOutputStream();
        resp.reset();
        resp.setHeader("Content-disposition", "attachment; filename=" + "teacher.xlsx");
        resp.setContentType("application/ms excel");
        EasyExcel.write(outputStream, Student.class).sheet("教师列表").doWrite(teachers);
        outputStream.flush();
        outputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
