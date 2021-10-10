package com.winson.spring.aop.overview;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.Arrays;

/**
 * @author winson
 * @date 2021/10/8
 **/
public class JDKDynamicProxyEchoServiceDemo {

    /**
     * 错误的proxy 创建方式
     */
    public static void errorCreateProxy(){
        ClassLoader errorClassLoader = new ClassLoader() {
            @Override
            protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
                System.out.println("errorClassLoader#loadClass() : " + name);
                return super.loadClass(name, resolve);
            }
        };

        EchoService echoService = (EchoService) Proxy.newProxyInstance(errorClassLoader, new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                DefaultEchoService service = new DefaultEchoService();
                Object result = service.echo((String) args[0]);
                return result;
            }
        });
        echoService.echo("error messgae ");
        System.out.println("error create echo service");
    }

    public static void main(String[] args) throws IOException {

//        errorCreateProxy();
//
//        if(1==1){
//            return;
//        }

        EchoService echoService = (EchoService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                DefaultEchoService service = new DefaultEchoService();
                Object result = service.echo((String) args[0]);
                return result;
            }
        });
//        ClassLoader myClassLoader = new ClassLoader() {
//            @Override
//            protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
//                System.out.println("load class : " + name);
//                return super.loadClass(name, resolve);
//            }
//        };
//        try {
//            Class clazz = myClassLoader.loadClass(echoService.getClass().getName());
//            System.out.println("custom load clazz : " + clazz);
//            System.out.println("custom load clazz.getClassLoader() : " + clazz.getClassLoader());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println(echoService.getClass().getName());
//        System.out.println(echoService.getClass().getClassLoader());
        long start = System.currentTimeMillis();
        String result = echoService.echo("hello world");
        System.out.println(result);
        long end = System.currentTimeMillis();
//        try {
//            System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println("use time : " + (end - start));

//        URL url = echoService.getClass().getClassLoader().getResource(echoService.getClass().getName());
//        System.out.println("url : " + url);
//        InputStream in = echoService.getClass().getResourceAsStream(echoService.getClass().getName());
//        System.out.println("class available length : " + in.available());

//        Class<?> clazz = echoService.getClass();
//        System.out.println("========= methods =========");
//        displayMethod(clazz.getMethods());
//        System.out.println("========= declared methods =========");
//        displayMethod(clazz.getDeclaredMethods());

    }

    public static void displayMethod(Method[] methods) {
        for (Method method : methods) {
            System.out.println(method.getName() + ", isPublic : " + Modifier.isPublic(method.getModifiers())
                    + " , isSynthetic : " + method.isSynthetic() + " , idBridge : " + method.isBridge());
        }
    }

}
