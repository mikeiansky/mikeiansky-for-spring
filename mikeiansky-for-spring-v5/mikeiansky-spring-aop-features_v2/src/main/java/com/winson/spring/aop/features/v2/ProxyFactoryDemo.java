package com.winson.spring.aop.features.v2;

import com.winson.spring.aop.features.v2.interceptor.MyInvalidInterceptor;
import com.winson.spring.aop.overviewv2.DefaultEchoService;
import com.winson.spring.aop.overviewv2.EchoService;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @author winson
 * @date 2022/4/17
 **/
public class ProxyFactoryDemo {

    public static void main(String[] args) {

        DefaultEchoService service = new DefaultEchoService();
//        service.sayHello("winson");

        ProxyFactory proxyFactory = new ProxyFactory(service);
//        proxyFactory.addAdvice(new MethodBeforeAdvice() {
//            @Override
//            public void before(Method method, Object[] args, Object target) throws Throwable {
//                System.out.println("method : " + method);
//                System.out.println("args : " + args);
//                System.out.println("target : " + target);
//            }
//        });
        proxyFactory.addAdvice(new MyInvalidInterceptor());

        EchoService target = (EchoService) proxyFactory.getProxy();
        target.sayHello("winson");
        System.out.println("split --------> 222");
        target.sayHello("winson2");
//        target.getCount();

    }

}
