package com.xzy.utils;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rep = (HttpServletResponse) servletResponse;

        String User = (String) req.getSession().getAttribute("user");

        if(User == null){
            rep.sendRedirect(req.getContextPath()+"/index.jsp");
            return;
        }else {
            filterChain.doFilter(req,rep);
            return;
        }

    }

    @Override
    public void destroy() {

    }
}
