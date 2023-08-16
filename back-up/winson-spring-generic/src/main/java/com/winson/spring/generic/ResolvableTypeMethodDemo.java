package com.winson.spring.generic;

import org.springframework.core.MethodParameter;
import org.springframework.core.ResolvableType;
import org.springframework.core.convert.TypeDescriptor;

import java.lang.reflect.Method;

/**
 * @author winson
 * @date 2022/3/6
 **/
public class ResolvableTypeMethodDemo {

    public String sayHello(String message, int time) {
        System.out.println("hello : " + message + " , time : " + time);
        return "change - " + message;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class clazz = ResolvableTypeMethodDemo.class;

        Method method = clazz.getMethod("sayHello", new Class[]{String.class, int.class});
        System.out.println("method : " + method);

        TypeDescriptor td = null;
        MethodParameter methodParameter = new MethodParameter(method, 0);

        ResolvableType rt = ResolvableType.forMethodParameter(methodParameter);
        System.out.println("rt.getType() : " + rt.getType());
        System.out.println("rt.getSuperType() : " + rt.getSuperType());
        System.out.println("rt.getComponentType() : " + rt.getComponentType());
        System.out.println("rt.getGenerics() : " + rt.getGenerics().length);
        System.out.println("rt.getInterfaces() : " + rt.getInterfaces().length);
        System.out.println("rt.getSource() : " + rt.getSource());
        System.out.println("rt.getNested(0) : " + rt.getNested(0));
        System.out.println("rt.getNested(1) : " + rt.getNested(1));

    }

}
