package com.winson.spring.aop.features.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author winson
 * @date 2021/10/9
 **/
@Aspect
public class AspectConfiguration {

    @Pointcut("execution(public * *(..))")
    public void anyPublicMethod() {
        System.out.println("any method pointcut");
    }

    @Before("anyPublicMethod()")
    public void before() {
        System.out.println("do before any method ");
    }

}
