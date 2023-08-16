package com.winson.spring.aop.overviewv2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author winson
 * @date 2022/4/16
 **/
public class CglibDynamicProxyDemoV1 {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DefaultEchoService.class);
        enhancer.setInterfaces(new Class[]{EchoService.class});
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib intercept --> method：" + method);
                System.out.println("cglib intercept --> objects：" + objects);
                System.out.println("cglib intercept --> methodProxy：" + methodProxy);
                return methodProxy.invokeSuper(o, objects);
            }
        });
//        DefaultEchoService service = (DefaultEchoService) enhancer.create();
//        EchoService service = (EchoService) enhancer.create();
        DefaultEchoService service = (DefaultEchoService) enhancer.create();
        service.sayHello("cglib");
//        System.out.println(service);

        DefaultEchoService de = new DefaultEchoService();
        System.out.println(de);

    }

}
