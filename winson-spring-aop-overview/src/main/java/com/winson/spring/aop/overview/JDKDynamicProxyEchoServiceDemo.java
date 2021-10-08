package com.winson.spring.aop.overview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author winson
 * @date 2021/10/8
 **/
public class JDKDynamicProxyEchoServiceDemo {

    public static void main(String[] args) {

        EchoService echoService = (EchoService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                DefaultEchoService service = new DefaultEchoService();
                Object result = service.echo((String) args[0]);
                return result;
            }
        });
        long start = System.currentTimeMillis();
        String result = echoService.echo("hello world");
        System.out.println(result);
        long end = System.currentTimeMillis();
        System.out.println("use time : " + (end - start));


    }

}
