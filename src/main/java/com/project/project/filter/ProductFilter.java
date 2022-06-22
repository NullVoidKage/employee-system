//package com.project.project.filter;
//
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import java.io.IOException;
//import java.util.logging.Filter;
//import java.util.logging.LogRecord;
//
//@Component
//public class ProductFilter implements Filter {
//    @Override
//    public void destroy() {}
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("Remote Host: " + request.getRemoteHost());
//        System.out.println("Remoted Address" + request.getRemoteAddr());
//        filterChain.doFilter(request, response);
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public boolean isLoggable(LogRecord record) {
//        return false;
//    }
//}
