package com.winson.spring.aop.features.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author winson
 * @date 2021/10/14
 **/
public class EchoServiceMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("method interceptor invocation : " + invocation);
        return invocation.proceed();
    }

}
