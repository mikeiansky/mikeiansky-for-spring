package com.winson.spring.aop.features.v2.interceptor;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author winson
 * @date 2022/4/23
 **/
public class MyInvalidInterceptor implements MethodInterceptor, MethodBeforeAdvice {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return invocation.proceed();
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

    }

}
