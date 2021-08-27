package com.winson.study.spring.mvc.v2;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author winson
 * @date 2021/8/27
 **/
public class MySessionListener implements HttpSessionListener {

    static {
        System.out.println("MySessionListener class init ");
    }

    public MySessionListener() {
        System.out.println("MySessionListener object construct ");

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("MySessionListener ------- create " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("MySessionListener xxxxxxx destroy ");
    }
}
