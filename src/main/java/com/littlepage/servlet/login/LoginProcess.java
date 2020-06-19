package com.littlepage.servlet.login;

import com.littlepage.entity.*;
import com.littlepage.service.*;
import com.littlepage.service.impl.*;
import com.littlepage.util.Md5Util;
import com.littlepage.util.SystemLogUtil;
import com.littlepage.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 登录处理
 */
@WebServlet(urlPatterns = "/loginProcess")
public class LoginProcess extends HttpServlet {
    LoginService loginService = new LoginServiceImpl();
    StudentService studentService = new StudentServiceImpl();
    TeacherService teacherService = new TeacherServiceImpl();
    AdminService adminService = new AdminServiceImpl();
    RootService rootService = new RootServiceImpl();
    SystemLogService systemLogService = new SystemLogServiceImpl();

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginName = req.getParameter("loginName");
        String password = req.getParameter("password");
        String type = req.getSession().getAttribute("loginType") == null ? "student": req.getSession().getAttribute("loginType").toString();
        String remember = req.getParameter("remember");
        // 记住密码
        recitePassword(loginName, password, type, remember, req, resp);
        // 三端登陆
        if(type.equals("admin")) {
            // 最高权限管理员登录
            boolean flag = rootAdmin(loginName, password, req, resp);
            // 学院级别管理员登录
            if(flag == false){
                academicAdminLogin(loginName, password, req, resp);
            }
        } else if(type.equals("student")) {
            // 学生登录
            studentLogin(loginName, password, req, resp);
        } else if(type.equals("teacher")) {
            // 老师登录
            teacherLogin(loginName, password, req, resp);
        }
    }

    /**
     * 记住密码
     * @param loginName
     * @param password
     * @param type
     * @param remember
     */
    private void recitePassword(String loginName, String password, String type, String remember, HttpServletRequest req, HttpServletResponse resp) {
        Cookie loginNameCookie = new Cookie("loginName", loginName.replace(" ", "-"));
        Cookie passwordCookie = new Cookie("password", password.replace(" ", "-"));
        logger.info(loginName + password + type);
        if(!(remember != null && remember.equals("on"))) {
            loginNameCookie.setMaxAge(0);
            passwordCookie.setMaxAge(0);
            req.getSession().setAttribute("remember", "");
        } else req.getSession().setAttribute("remember", "checked");
        resp.addCookie(loginNameCookie);
        resp.addCookie(passwordCookie);
    }

    /**
     * 超级管理员登录
     * @param loginName
     * @param password
     * @param req
     * @param resp
     * @return
     */
    private boolean rootAdmin(String loginName, String password, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean success = loginService.loginRootAdmin(loginName, Md5Util.getMD5Str(password));
        if(success) {
            Root root = rootService.selectRootByRootAdminName(loginName);
            SystemLogUtil.systemLogProcess(req.getRemoteAddr(), root.getName(), "超级管理员", TimeUtil.now(), "登录成功");
            req.getSession().setAttribute("user", root);
            req.getSession().setAttribute("message", "超级管理员" + root.getName() + "登录成功");
            req.getSession().setAttribute("type", "超级管理员");
            req.getSession().setAttribute("username", root.getName());
            resp.sendRedirect("manage/admin/showstudents");
        }
        return success;
    }

    /**
     * 教师登录
     * @param loginName
     * @param password
     * @param req
     * @param resp
     * @throws IOException
     */
    private void teacherLogin(String loginName, String password, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean success = loginService.loginTeacher(loginName, Md5Util.getMD5Str(password));
        if(success) {
            Teacher teacher = teacherService.selectTeacherByTeaNum(loginName);
            SystemLogUtil.systemLogProcess(req.getRemoteAddr(), teacher.getName(), "教师", TimeUtil.now(), "登录成功");
            req.getSession().setAttribute("user", teacher);
            req.getSession().setAttribute("message", "教师" + teacher.getName() + "登录成功");
            req.getSession().setAttribute("type", "教师");
            req.getSession().setAttribute("username", teacher.getName());
            resp.sendRedirect("manage/teacher/showstudents");
        } else {
            SystemLogUtil.systemLogProcess(req.getRemoteAddr(), loginName, "教师", TimeUtil.now(), "登录失败");
            req.getSession().setAttribute("wrongMsg", "用户名或密码错误");
            resp.sendRedirect("login?type=teacher");
        }
    }

    /**
     * 学院级别管理员
     * @param loginName
     * @param password
     * @param req
     * @param resp
     * @throws IOException
     */
    private void academicAdminLogin(String loginName, String password, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean success = loginService.loginAdmin(loginName, Md5Util.getMD5Str(password));
        if(success) {
            Admin admin = adminService.selectAdminByLoginName(loginName);
            SystemLogUtil.systemLogProcess(req.getRemoteAddr(), admin.getName(), "学院管理员", TimeUtil.now(), "登录成功");
            req.getSession().setAttribute("user", admin);
            req.getSession().setAttribute("message", "管理员" + loginName + "登录成功");
            req.getSession().setAttribute("type", "学院管理员");
            req.getSession().setAttribute("username", loginName);
            resp.sendRedirect("manage/admin/showstudents");
        } else {
            SystemLogUtil.systemLogProcess(req.getRemoteAddr(), loginName, "管理员", TimeUtil.now(), "登录失败");
            // 记住密码的取用
            req.getSession().setAttribute("wrongMsg", "用户名或密码错误");
            resp.sendRedirect("login?type=admin");
        }
    }

    /**
     * 学生登录
     * @param loginName
     * @param password
     */
    private void studentLogin(String loginName, String password, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean success = loginService.loginStudent(loginName, Md5Util.getMD5Str(password));
        if(success) {
            Student student = studentService.selectStudentByStuNum(loginName);
            SystemLogUtil.systemLogProcess(req.getRemoteAddr(), student.getName(), "学生", TimeUtil.now(), "登录成功");
            req.getSession().setAttribute("user", student);
            req.getSession().setAttribute("message", "学生" + student.getName() + "登录成功");
            req.getSession().setAttribute("type", "学生");
            req.getSession().setAttribute("username", student.getName());
            resp.sendRedirect("manage/student/showteachers");
        } else {
            SystemLogUtil.systemLogProcess(req.getRemoteAddr(), loginName, "学生", TimeUtil.now(), "登录失败");
            req.getSession().setAttribute("wrongMsg", "用户名或密码错误");
            resp.sendRedirect("login?type=student");
        }
    }
}
