package com.winson.spring.aop.features;

import com.winson.spring.aop.features.advice.MyThrowsAdvice;
import com.winson.spring.aop.overview.DefaultEchoService;
import com.winson.spring.aop.overview.EchoService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;


/**
 * @author winson
 * @date 2021/10/9
 **/
public class ProxyFactoryDemo {

    public static void main(String[] args) {

        DefaultEchoService echoService = new DefaultEchoService();

//        echoService.echo("hello");

        ProxyFactory proxyFactory = new ProxyFactory(echoService);
//        proxyFactory.setOptimize(true);
//        proxyFactory.setTargetClass(EchoService.class);
//        proxyFactory.setTargetSource(TargetSource);
        proxyFactory.addAdvice(new AfterReturningAdvice() {

            @Override
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                System.out.println("AfterReturningAdvice afterReturning : " + method);

            }
        });
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("MethodBeforeAdvice invocation : " + method);
            }
        });
        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("Normal method invocation 1: " + invocation);
                return invocation.proceed();
            }
        });
        proxyFactory.addAdvice(new MyThrowsAdvice());

        EchoService proxy = (EchoService) proxyFactory.getProxy();
        // 会重复创建 AopProxy
        EchoService proxy2 = (EchoService) proxyFactory.getProxy();

        System.out.println(proxy.echo("Hello,world!"));


    }

}
