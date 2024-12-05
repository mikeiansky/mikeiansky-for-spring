package com.winson.spring.aop.overviewv2;

import java.lang.reflect.Method;

/**
 * @author winson
 * @date 2022/4/16
 **/
public class JdkBeforeInterceptor {

    public void before(Object target, Method method, Object[] args) {
        System.out.println("before target : " + target);
        System.out.println("before method : " + method);
        System.out.println("before args : " + args);
    }

}
