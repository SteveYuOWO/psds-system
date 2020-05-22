package com.littlepage.servlet.studentmanage.admin;

import com.alibaba.excel.EasyExcel;
import com.littlepage.entity.Student;
import com.littlepage.service.StudentService;
import com.littlepage.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/manage/admin/exportStudents")
public class ExportStudent extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = studentService.selectStudents(0, Integer.MAX_VALUE);
        ServletOutputStream outputStream = resp.getOutputStream();
        resp.reset();
        resp.setHeader("Content-disposition", "attachment; filename=" + "student.xlsx");
        resp.setContentType("application/ms excel");
        EasyExcel.write(outputStream, Student.class).sheet("学生列表").doWrite(studentList);
        outputStream.flush();
        outputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
