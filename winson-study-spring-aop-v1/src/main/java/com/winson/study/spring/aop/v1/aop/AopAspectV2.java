package com.winson.study.spring.aop.v1.aop;

import com.winson.study.spring.aop.v1.bean.Human;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author winson
 * @date 2021/7/19
 **/
@Component
@Aspect
public class AopAspectV2 {

//    @Before("this(com.winson.study.spring.aop.v1.service.HelloService)")
//    public void thisBefore(){
//        System.out.println("this before -----> ");
//    }

    @Before("execution(* com.winson.study.spring.aop.v1.service..*an(..)) && args(human)")
    public void beforeSay(JoinPoint joinPoint, Human human) {
        System.out.println("before say human : " + human);
    }

//    @Before("execution(* com.winson.study.spring.aop.v1.service..*an(human))")
//    public void beforeSay(JoinPoint joinPoint, Human human) {
//        System.out.println("before say human : " + human);
//    }

}
