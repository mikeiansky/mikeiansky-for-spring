package com.winson.spring.aop.features.v2.aspect;

import org.aspectj.lang.JoinPoint;

/**
 * @author winson
 * @date 2022/4/17
 **/
public class AspectXmlConfig {

    public void publicBefore(JoinPoint joinPoint) {
        System.out.println("publicBefore joinPoint : " + joinPoint);
    }

}
