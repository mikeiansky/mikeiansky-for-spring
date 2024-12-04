package com.winson.spring.aop.overview;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author winson
 * @date 2021/10/9
 **/
public class CglibDynamicProxyDemo {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DefaultEchoService.class);
        enhancer.setInterfaces(new Class[]{EchoService.class});
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("intercept name : " + method.getName());
                System.out.println("methodProxy.getSignature : " + methodProxy.getSignature());
                System.out.println("methodProxy.getClass : " + methodProxy.getClass());
                System.out.println("methodProxy.getSuperName : " + methodProxy.getSuperName());
                System.out.println("methodProxy.getSuperIndex : " + methodProxy.getSuperIndex());
//                System.out.println("methodProxy.getSuperIndex : " + o.getClass());
//                return methodProxy.invoke(method, objects);
//                return methodProxy.invoke(o, objects);
                return methodProxy.invokeSuper(o, objects);
            }
        });

        EchoService echoService = (EchoService) enhancer.create();
        System.out.println("echoService : " + echoService);

    }

}
