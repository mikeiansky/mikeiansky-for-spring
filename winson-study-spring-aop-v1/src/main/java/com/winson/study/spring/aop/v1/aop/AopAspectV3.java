package com.winson.study.spring.aop.v1.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author winson
 * @date 2021/7/20
 **/
@Aspect
public class AopAspectV3 {

    @Before("this(com.winson.study.spring.aop.v1.service.HelloService)")
    public void thisHelloServiceBefore(){
        System.out.println("This => Hello Service before -----> ");
    }

    @Before("target(com.winson.study.spring.aop.v1.service.HelloService)")
    public void targetHelloServiceBefore(){
        System.out.println("target => Hello Service before -----> ");
    }

    @Before("within(com.winson.study.spring.aop.v1.service.HelloService)")
    public void withinHelloServiceBefore(){
        System.out.println("within => Hello Service before -----> ");
    }

}
