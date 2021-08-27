package com.winson.study.spring.mvc.v2;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @author winson
 * @date 2021/8/27
 **/
public class MyServletRequestListener implements ServletRequestListener {

    static {
        System.out.println("MyServletRequestListener class init ");
    }

    public MyServletRequestListener() {
        System.out.println("MyServletRequestListener object construct ");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("MyServletRequestListener requestDestroyed sre " + sre.getServletRequest());

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("MyServletRequestListener requestInitialized sre " + sre.getServletRequest());
    }
}
