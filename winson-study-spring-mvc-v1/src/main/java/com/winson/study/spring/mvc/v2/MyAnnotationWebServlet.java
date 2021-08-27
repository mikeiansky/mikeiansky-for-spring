package com.winson.study.spring.mvc.v2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

/**
 * @author winson
 * @date 2021/8/27
 **/
@WebServlet(urlPatterns = "/myservlet", loadOnStartup = 1, initParams = {
        @WebInitParam(name = "dispatch-servlet", value = "winson-dispatch"),
        @WebInitParam(name = "company", value = "ciwei")
})
public class MyAnnotationWebServlet extends HttpServlet {

    static {
        System.out.println("MyAnnotationWebServlet class init ... " + new Date());
    }

    public MyAnnotationWebServlet() {
        System.out.println("MyAnnotationWebServlet object init ... ");
//        System.out.println("dispatch-servlet on construct : "+getInitParameter("dispatch-servlet"));
//        System.out.println("company-servlet on construct : "+getInitParameter("company"));


    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("dispatch-servlet on init : " + getInitParameter("dispatch-servlet"));
        System.out.println("company-servlet on init : " + getInitParameter("company"));

        System.out.println(getServletConfig().getServletContext());
        System.out.println(getServletContext());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie cookie = new Cookie("winsons", "ciwei-winson");
//        cookie.setMaxAge(60 * 60 * 24);
//        cookie.setPath("winsonDemo");
//
//        resp.addCookie(cookie);

        //使用PrintWriter.write()方法gaifang向前台页面输出内容
        PrintWriter writer = resp.getWriter();
        writer.write("welcome to winson ' s web haha hehe hehe aa");
        writer.close();
//        doGet(req, resp);
        System.out.println(getInitParameter("dispatch-servlet"));
        System.out.println(getInitParameter("company"));
        System.out.println("------------");
        System.out.println(getServletContext().getInitParameter("dispatch-servlet"));
        System.out.println(getServletContext().getInitParameter("company"));
        System.out.println("-------last guy -------");
        System.out.println("last guy is : " + getServletContext().getAttribute("last"));
        getServletContext().setAttribute("last", "myservlet v1");
        System.out.println("-------*********---------");

        System.out.println("Method : " + req.getMethod());
        System.out.println("RequestURI : " + req.getRequestURI());
        System.out.println("RequestURL : " + req.getRequestURL());
        System.out.println("ServletPath : " + req.getServletPath());
        System.out.println("ContextPath : " + req.getContextPath());
        System.out.println("QueryString : " + req.getQueryString());
        System.out.println("RemoteAddr : " + req.getRemoteAddr());
        System.out.println("RemoteHost : " + req.getRemoteHost());
        System.out.println("RemoteUser : " + req.getRemoteUser());
        System.out.println("RemotePort : " + req.getRemotePort());
        System.out.println("--------- 2 -------");
        String[] vs = Optional.ofNullable(req.getParameterValues("name"))
                .orElse(new String[]{});
        System.out.println("params : " + Arrays.toString(vs));
        System.out.println("params : " + req.getParameterMap());

//        req.getSession().setAttribute("winson", "haha");

        System.out.println("---------- cookies ----------");
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " -> " + cookie.getValue());
            }
        }

        req.getSession().getId();
//        req.getSession().invalidate();;

    }

}
