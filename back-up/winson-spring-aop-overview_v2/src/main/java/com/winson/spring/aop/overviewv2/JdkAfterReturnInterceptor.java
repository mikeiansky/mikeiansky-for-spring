package com.winson.spring.aop.overviewv2;

import java.lang.reflect.Method;

/**
 * @author winson
 * @date 2022/4/16
 **/
public class JdkAfterReturnInterceptor {

    public void afterReturn(Object target, Method method, Object result, Object[] args) {
        System.out.println("afterReturn target:" + target);
        System.out.println("afterReturn method:" + method);
        System.out.println("afterReturn result:" + result);
        System.out.println("afterReturn args:" + args);
    }

}
