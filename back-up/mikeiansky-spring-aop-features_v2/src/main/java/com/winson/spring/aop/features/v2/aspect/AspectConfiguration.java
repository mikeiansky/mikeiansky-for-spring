package com.winson.spring.aop.features.v2.aspect;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;

/**
 * @author winson
 * @date 2022/4/19
 **/
@Aspect
public class AspectConfiguration {

    @Pointcut("execution(public * *(..))")
    public void anyPublic(){

    }

    @Before("anyPublic()")
    public void beforeAnyPublic(){
//        MethodInvocation invocation = ExposeInvocationInterceptor.currentInvocation();
//        System.out.println("before -------> : " + invocation);
        System.out.println("aspect configuration before");
    }

//    public void plainMethodOne(){
//        System.out.println("plain method one");
//    }

//    public void plainMethodTwo(){
//        System.out.println("plain method two");
//    }

}
