package com.winson.spring.aop.features.v2;

import com.winson.spring.aop.features.v2.aspect.AspectConfiguration;
import com.winson.spring.aop.overviewv2.DefaultEchoService;
import com.winson.spring.aop.overviewv2.EchoService;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import java.lang.reflect.Method;

/**
 * @author winson
 * @date 2022/4/19
 **/
public class AspectJAnnotationUsingApiDemo {

    public static void main(String[] args) {

        DefaultEchoService target = new DefaultEchoService();


        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectConfiguration.class);
        proxyFactory.addAdvice(new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                System.out.println("afterReturning returnValue : " + returnValue);
            }
        });

        EchoService echoService = proxyFactory.getProxy();
        echoService.sayHello("winson");

    }

}
