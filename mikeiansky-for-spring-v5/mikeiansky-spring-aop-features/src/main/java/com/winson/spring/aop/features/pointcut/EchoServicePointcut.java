package com.winson.spring.aop.features.pointcut;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author winson
 * @date 2021/10/14
 **/
public class EchoServicePointcut extends StaticMethodMatcherPointcut {

    private final String methodName;

    private final Class targetClass;

    public EchoServicePointcut(String methodName, Class targetClass) {
        this.methodName = methodName;
        this.targetClass = targetClass;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return method.getName().equals(methodName)
                && this.targetClass.isAssignableFrom(targetClass);
    }

}
