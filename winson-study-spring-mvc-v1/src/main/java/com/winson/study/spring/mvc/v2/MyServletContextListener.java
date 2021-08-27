package com.winson.study.spring.mvc.v2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author winson
 * @date 2021/8/27
 **/
public class MyServletContextListener implements ServletContextListener {

    static {
        System.out.println("MyServletContextListener class init");
    }

    public MyServletContextListener() {
        System.out.println("MyServletContextListener object init");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("MyServletContextListener contextInitialized sce : " + sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("MyServletContextListener contextDestroyed sce : " + sce.getServletContext());
    }
}
