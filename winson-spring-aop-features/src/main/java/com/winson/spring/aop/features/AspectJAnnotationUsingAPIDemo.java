package com.winson.spring.aop.features;

import com.winson.spring.aop.features.aspect.AspectConfiguration;
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

        Map<String ,Object> cache = new HashMap<>();
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(cache);
        aspectJProxyFactory.addAspect(new AspectConfiguration());

        aspectJProxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.printf("method name : %s, args : %s, target : %s \n", method.getName(), Arrays.asList(args), target);
                System.out.printf("test : %s \n",target);
                method.invoke(target, args);
            }
        });

        Map<String,Object> proxyCache = aspectJProxyFactory.getProxy();
        proxyCache.put("key1", "A");
        System.out.println(proxyCache.get("key1"));

    }

}
