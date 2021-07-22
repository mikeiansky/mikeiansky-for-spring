package com.winson.study.spring.mvc.controller.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author winson
 * @date 2021/7/22
 **/
public class WinsonFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Winson Filter init");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Winson Filter do Filter");
        chain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("Winson Filter destroy!");
    }
}
