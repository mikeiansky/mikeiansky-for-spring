package com.winson.study.spring.aop.v1.aop;

import com.winson.study.spring.aop.v1.annotation.SayHandle;
import com.winson.study.spring.aop.v1.bean.Human;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author winson
 * @date 2021/7/19
 **/
@Component
@Aspect
public class AopAspect {

    @Pointcut("execution(public * com.winson.study.spring.aop.v1.service.HelloService.sayHello(..))")
    public void pointCut() {

    }

    @Pointcut("@within(com.winson.study.spring.aop.v1.annotation.SayHandle)")
    public void withSayHandleAnnotation() {

    }

    @Pointcut("@within(com.winson.study.spring.aop.v1.annotation.Admin)")
    public void withAdminAnnotation() {

    }

    @Pointcut("@within(com.winson.study.spring.aop.v1.annotation.Visitor)")
    public void withVisitorAnnotation() {

    }

    @Pointcut("within(com.winson.study.spring.aop.v1.service.HelloServiceSub)")
    public void withSubPointCut() {

    }

    @Pointcut("within(com.winson.study.spring.aop.v1.service.HelloService)")
    public void withPointCut() {

    }

    @Pointcut("target(com.winson.study.spring.aop.v1.service.HelloServiceSub)")
    public void targetPointCut() {

    }

    @Pointcut("args(msg,count)")
    public void argPointCut(String msg, int count) {

    }

    @Before("this(com.winson.study.spring.aop.v1.service.HelloService)")
    public void thisBefore(){
        System.out.println("this before -----> ");
    }

    @Before("withSayHandleAnnotation()")
    public void withSayHandleAnnotationBefore() {
        System.out.println("withSayHandleAnnotationBefore @Before run");
    }

    @Before("withVisitorAnnotation()")
    public void withVisitorAnnotationBefore() {
        System.out.println("withVisitorAnnotationBefore @Before run");
    }

    @Before("withAdminAnnotation()")
    public void withAdminAnnotationBefore() {
        System.out.println("withAdminAnnotationBefore @Before run");
    }

    @Before("targetPointCut()")
    public void targetBefore() {
        System.out.println("HelloService targetBefore @Before run");
    }

    @Before("withSubPointCut()")
    public void withSubBefore() {
        System.out.println("withSubBefore @Before run");
    }

    @Before("withPointCut()")
    public void withBefore() {
        System.out.println("withBefore @Before run");
    }

    @Before("pointCut()")
    public void executionBefore() {
        System.out.println("executionBefore @Before aspect run ... ");
    }

    @AfterReturning("pointCut()")
    public void executionAfterReturn() {
        System.out.println("executionAfterReturn @AfterReturning aspect run ... ");
    }

    @After("pointCut()")
    public void executionAfter() {
        System.out.println("executionAfter @After aspect run ... ");
    }

    @Before("@annotation(sayHandle) && bean(helloServiceSub)")
    public void beforeMethodAnnotation(JoinPoint joinPoint, SayHandle sayHandle) {
        System.out.println("beforeMethodAnnotation @Before aspect run ... ");
    }


    @Before("argPointCut(msg,count)")
    public void beforeArg(JoinPoint joinPoint, String msg, int count) {
        System.out.println("beforeArg ==> argPointCut , msg: " + msg + " , count : " + count);
    }

//    @Before("args(msg,count)")
//    public void beforeArg(JoinPoint joinPoint, String msg, int count) {
//        System.out.println("beforeArg @Before msg:" + msg + " , count : " + count);
//    }

    @Before("args(human)")
    public void beforeArgExtend(JoinPoint joinPoint, Human human){
        System.out.println("Before Arg Extend => " + human);
    }

}
