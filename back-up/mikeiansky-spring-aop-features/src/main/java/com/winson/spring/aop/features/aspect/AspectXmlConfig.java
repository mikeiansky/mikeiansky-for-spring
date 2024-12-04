package com.winson.spring.aop.features.aspect;

import org.aspectj.lang.JoinPoint;

/**
 * @author winson
 * @date 2021/10/14
 **/
public class AspectXmlConfig {

    public void publicBefore(JoinPoint joinPoint){
        System.out.println("public before invocation , join point : " + joinPoint + " , joinPoint.getTarget() : " + joinPoint.getTarget());
    }

}
