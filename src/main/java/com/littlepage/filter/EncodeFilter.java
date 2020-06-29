package com.littlepage.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "encodeFilter", urlPatterns = "/*")
public class EncodeFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(EncodeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("starting encode filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String uri = ((HttpServletRequest)request).getRequestURI();
        if(uri.indexOf("css") > 0 || uri.indexOf("js") > 0 || uri.indexOf("png") > 0) {
            filterChain.doFilter(request, response);
            return;
        }
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("destroy encode filter");
    }
}
