package com.winson.spring.aop.overviewv2;

import java.lang.reflect.Proxy;

/**
 * @author winson
 * @date 2022/4/16
 **/
public class JdkDynamicProxyDemoV1 {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> result = Class.forName("com.winson.spring.aop.overviewv2.EchoService");
        System.out.println(result);

        DefaultEchoService defaultEchoService = new DefaultEchoService();
        EchoService echoService = (EchoService) Proxy.newProxyInstance(
                DefaultEchoService.class.getClassLoader(),new Class[]{EchoService.class},
                new EchoServiceHandler(defaultEchoService));
//        System.out.println("echoService is : " + echoService);
//        echoService.sayHello("winson");
        echoService.sayHello(null);

    }

}
