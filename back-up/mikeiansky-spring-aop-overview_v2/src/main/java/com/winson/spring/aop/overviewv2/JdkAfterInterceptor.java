package com.winson.spring.aop.overviewv2;

import java.lang.reflect.Method;

/**
 * @author winson
 * @date 2022/4/16
 **/
public class JdkAfterInterceptor {

    public void after(Object target, Method method, Object[] args) {
        System.out.println("after target : " + target);
        System.out.println("after method : " + method);
        System.out.println("after args : " + args);
    }

}
