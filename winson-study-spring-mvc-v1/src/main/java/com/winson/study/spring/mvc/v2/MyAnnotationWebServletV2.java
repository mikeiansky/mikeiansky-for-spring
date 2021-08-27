package com.winson.study.spring.mvc.v2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author winson
 * @date 2021/8/27
 **/
@WebServlet(urlPatterns = "/myservletv2", loadOnStartup = 1,initParams = {
        @WebInitParam(name = "dispatch-servlet", value = "winson-dispatch-v2"),
        @WebInitParam(name = "company",value = "ciwei-v2")
})
public class MyAnnotationWebServletV2 extends HttpServlet {

    static {
        System.out.println("MyAnnotationWebServlet v2 class init ... " + new Date());
    }

    public MyAnnotationWebServletV2() {
        System.out.println("MyAnnotationWebServlet v2 object init ... ");
//        System.out.println("dispatch-servlet on construct : "+getInitParameter("dispatch-servlet"));
//        System.out.println("company-servlet on construct : "+getInitParameter("company"));



    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("dispatch-servlet v2 on init : "+getInitParameter("dispatch-servlet"));
        System.out.println("company-servlet v2 on init : "+getInitParameter("company"));

        System.out.println(getServletConfig().getServletContext());
        System.out.println(getServletContext());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用PrintWriter.write()方法gaifang向前台页面输出内容
        PrintWriter writer = resp.getWriter();
        writer.write("welcome to winson ' s web haha hehe hehe aa v2");
        writer.close();
//        doGet(req, resp);
        System.out.println(getInitParameter("dispatch-servlet"));
        System.out.println(getInitParameter("company"));
        System.out.println("------------");
        System.out.println(getServletContext().getInitParameter("dispatch-servlet"));
        System.out.println(getServletContext().getInitParameter("company"));
        System.out.println("-------last guy -------");
        System.out.println("last guy is : " + getServletContext().getAttribute("last"));
        getServletContext().setAttribute("last", "myservlet v2");


    }

}
