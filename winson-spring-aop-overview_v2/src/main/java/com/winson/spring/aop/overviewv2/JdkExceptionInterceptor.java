package com.winson.spring.aop.overviewv2;

import java.lang.reflect.Method;

/**
 * @author winson
 * @date 2022/4/16
 **/
public class JdkExceptionInterceptor {

    public void catchException(Object target, Method method, Object[] args, Exception exception) {
        System.out.println("catchException target: " + target);
        System.out.println("catchException method: " + method);
        System.out.println("catchException args: " + args);
        System.out.println("catchException exception: " + exception);
    }

}
