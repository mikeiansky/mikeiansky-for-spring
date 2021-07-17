package com.winson.study.spring.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author winson
 * @date 2021/7/17
 **/
@Aspect
public class SimpleAop {

    @Pointcut("execution(public * com.winson.study.spring.annotation.bean.MathCalculate.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void beforeRun(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + " -> @Before run ... ");
    }

    @After("pointCut()")
    public void afterRun(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + " -> @After run ... ");
    }

    @Around("pointCut()")
    public Object aroundRun(ProceedingJoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + " -> @Around run ... ");
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @AfterThrowing(pointcut = "pointCut()" , throwing = "exception")
    public void exceptionRun(JoinPoint joinPoint, Exception exception){
        System.out.println(joinPoint.getSignature().getName() + " -> @AfterThrowing run ... exception:" + exception);
    }

//    @AfterReturning(pointcut = "pointCut()", returning = "result")
//    public void returnRun(JoinPoint joinPoint, Object result){
//        System.out.println(joinPoint.getSignature().getName() + " -> @AfterReturning run ... result : " + result);
//    }

}
