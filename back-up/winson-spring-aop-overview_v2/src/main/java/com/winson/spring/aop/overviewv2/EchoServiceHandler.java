package com.winson.spring.aop.overviewv2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author winson
 * @date 2022/4/16
 **/
public class EchoServiceHandler implements InvocationHandler {

    public Object target;

    private JdkBeforeInterceptor jdkBeforeInterceptor;

    private JdkAfterInterceptor jdkAfterInterceptor;

    private JdkExceptionInterceptor jdkExceptionInterceptor;
    private JdkAfterReturnInterceptor jdkAfterReturnInterceptor;

    public EchoServiceHandler(Object target) {
        this.target = target;
        jdkBeforeInterceptor = new JdkBeforeInterceptor();
        jdkAfterInterceptor = new JdkAfterInterceptor();
        jdkExceptionInterceptor = new JdkExceptionInterceptor();
        jdkAfterReturnInterceptor = new JdkAfterReturnInterceptor();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        jdkBeforeInterceptor.before(target, method, args);
        Object result = null;
        try {
            result = method.invoke(target, args);
            jdkAfterInterceptor.after(target, method, args);
        } catch (Exception exception) {
            jdkExceptionInterceptor.catchException(target, method, args, exception);
        } finally {
            jdkAfterReturnInterceptor.afterReturn(target, method, result, args);
        }
        return result;
    }

}
