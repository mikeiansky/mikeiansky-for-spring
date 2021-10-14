package com.winson.spring.aop.features;

import com.winson.spring.aop.features.aspect.AspectConfiguration;
import com.winson.spring.aop.overview.DefaultEchoService;
import com.winson.spring.aop.overview.EchoService;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author winson
 * @date 2021/10/9
 **/
public class AspectJAnnotationUsingAPIDemo {

    public static void main(String[] args) {

        Map<String, Object> cache = new HashMap<>();
        DefaultEchoService echoService = new DefaultEchoService();

        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(echoService);
//        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(cache);
        aspectJProxyFactory.addAspect(new AspectConfiguration());

        aspectJProxyFactory.addAdvice(new MethodBeforeAdvice() {

            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.printf("before-1 method name : %s, args : %s, target : %s \n", method.getName(), Arrays.asList(args), target);
                System.out.printf("before-1 test : %s \n", target);
                method.invoke(target, args);
            }

        });

//        aspectJProxyFactory.addAdvice(new MethodBeforeAdvice() {
//
//            @Override
//            public void before(Method method, Object[] args, Object target) throws Throwable {
//                System.out.printf("before-2 method name : %s, args : %s, target : %s \n", method.getName(), Arrays.asList(args), target);
//                System.out.printf("before-2 test : %s \n", target);
//                method.invoke(target, args);
//            }
//
//        });
//
//        aspectJProxyFactory.addAdvice(new AfterReturningAdvice() {
//            @Override
//            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
//                System.out.printf("afterReturning-1 method name : %s, args : %s, target : %s \n", method.getName(), Arrays.asList(args), target);
//                System.out.printf("afterReturning-1 test : %s , returnValue %s \n", target, returnValue);
//                method.invoke(target, args);
//            }
//
//        });

        aspectJProxyFactory.addAdvice(new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                System.out.printf("afterReturning-2 method name : %s, args : %s, target : %s \n", method.getName(), Arrays.asList(args), target);
                System.out.printf("afterReturning-2 test : %s , returnValue %s \n", target, returnValue);
                method.invoke(target, args);
            }

        });

//        Map<String, Object> proxyCache = aspectJProxyFactory.getProxy();
        // 无缓存处理
//        proxyCache.put("key1", "A");
//        // 这之后会有缓存
//        proxyCache.put("key1", "B");
//        proxyCache.put("key2", "B");
//        System.out.println(proxyCache.get("key1"));

        EchoService es = aspectJProxyFactory.getProxy();
        String result = es.echo("Hello,world");
        System.out.println("result : "+result);

    }

}
