package com.winson.spring.aop.overview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author winson
 * @date 2021/10/8
 **/
public class AopInterceptorDemo {

    public static void main(String[] args) {

        EchoService echoService = (EchoService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object result = null;
                if(EchoService.class.isAssignableFrom(proxy.getClass())){
                    Long startTime = 0L;
                    Long endTime = 0L;
                    try {

                        BeforeInterceptor beforeInterceptor = new BeforeInterceptor() {
                            @Override
                            public Object before(Object obj, Method method, Object[] args) {
                                return System.currentTimeMillis();
                            }
                        };
                        startTime = (Long) beforeInterceptor.before(proxy, method, args);
                        DefaultEchoService service = new DefaultEchoService();
//                    result.toString();
                        result = service.echo((String) args[0]);


                        AfterReturnInterceptor afterReturnInterceptor = new AfterReturnInterceptor() {
                            @Override
                            public Object after(Object obj, Method method, Object[] args, Object result) {
                                return System.currentTimeMillis();
                            }
                        };
                        endTime = (Long) afterReturnInterceptor.after(proxy, method, args, result);
                    }catch (Throwable e){
                        ExceptionInterceptor exceptionInterceptor = new ExceptionInterceptor() {
                            @Override
                            public Object withException(Object obj, Method method, Object[] args, Throwable throwable) {
                                System.out.println("with exception : " + throwable);
                                return null;
                            }
                        };
                        exceptionInterceptor.withException(proxy, method, args, e);

                    } finally {
                        FinallyInterceptor finallyInterceptor = new TimeSpendInterceptor(startTime, endTime);
                        Object costTime = finallyInterceptor.finalize(proxy, method, args, result);
                        System.out.println("use time : " + costTime);
                    }
                }



                return result;
            }

        });
        String result = echoService.echo("Hello,World");
        System.out.println(result);

    }

}
