package com.winson.spring.aop.features;

import com.winson.spring.aop.features.aspect.AspectConfiguration;
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
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(cache);
        aspectJProxyFactory.addAspect(new AspectConfiguration());

        aspectJProxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.printf("before method name : %s, args : %s, target : %s \n", method.getName(), Arrays.asList(args), target);
                System.out.printf("before test : %s \n", target);
                method.invoke(target, args);
            }
        });
//        aspectJProxyFactory.addAdvice(new AfterReturningAdvice() {
//            @Override
//            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
//                System.out.printf("afterReturning method name : %s, args : %s, target : %s \n", method.getName(), Arrays.asList(args), target);
//                System.out.printf("afterReturning test : %s , returnValue %s \n", target, returnValue);
//                method.invoke(target, args);
//            }
//
//        });

        Map<String, Object> proxyCache = aspectJProxyFactory.getProxy();
        proxyCache.put("key1", "A");
        proxyCache.put("key2", "B");
        System.out.println(proxyCache.get("key1"));

//        int i = 0;
//        System.out.println(++i);
//        System.out.println(i);
//        int j = 0;
//        System.out.println(j++);
//        System.out.println(j);

    }

}
