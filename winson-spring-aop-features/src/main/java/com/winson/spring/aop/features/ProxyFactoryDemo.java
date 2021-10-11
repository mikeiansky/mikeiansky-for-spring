package com.winson.spring.aop.features;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.geekbang.thinking.in.spring.aop.overview.DefaultEchoService;
import org.geekbang.thinking.in.spring.aop.overview.EchoService;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.TargetSource;
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
        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("invocation 1: " + invocation);
                return invocation.proceed();
            }
        });
        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("invocation 2: " + invocation);
                return invocation.proceed();
            }
        });
        EchoService proxy = (EchoService) proxyFactory.getProxy();

        System.out.println(proxy.echo("Hello,world!"));


    }

}
