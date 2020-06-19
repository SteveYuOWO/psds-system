package com.littlepage.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
@WebFilter(filterName = "managefilter", urlPatterns = "/manage/*")
public class ManageFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(ManageFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("权限管理启动");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Object type = request.getSession().getAttribute("type");
        if(type == null) {
            response.sendRedirect(request.getContextPath());
            return;
        } else {
            String servletPath = request.getServletPath();
            // root管理员特权
            if(type.toString().equals("学院管理员") && servletPath.contains("manage/admin/showAdmin")) {
                response.sendRedirect(request.getContextPath() + "/logout");
                return;
            }
            // 学院管理员
            if(type.toString().contains("管理员") && servletPath.contains("manage/admin")) {
                chain.doFilter(req, resp);
            } else if(type.toString().equals("学生") && servletPath.contains("manage/student")) {
                chain.doFilter(req, resp);
            } else if(type.toString().equals("教师") && servletPath.contains("manage/teacher")) {
                chain.doFilter(req, resp);
            } else {
                response.sendRedirect(request.getContextPath() + "/logout");
            }
        }
    }

    @Override
    public void destroy() {
        logger.info("权限管理关闭");
    }
}
