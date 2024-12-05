package com.winson.spring.aop.features.v2.interceptor;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * @author winson
 * @date 2022/4/17
 **/
public class EchoServiceMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("EchoServiceMethodInterceptor invocation : " + invocation);
        return invocation.proceed();
    }

}
