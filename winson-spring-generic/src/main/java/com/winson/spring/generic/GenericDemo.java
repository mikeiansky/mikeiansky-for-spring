package com.winson.spring.generic;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author winson
 * @date 2021/10/4
 **/
public class GenericDemo<E> {

    public E e1;

    public void method(E e) {
    }

    public static <E> E method2(E e) {
        return e;
    }

    public void testMethod2() {
        String a = method2("test");
        int g = method2(0);
    }

    public static void main(String[] args) {

        Class clazz = StringList.class;

        System.out.println(clazz.getSuperclass());
        System.out.println(clazz.getGenericSuperclass());
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        System.out.println(parameterizedType.getRawType());
        System.out.println("getActualTypeArguments == ");
        Arrays.stream(parameterizedType.getActualTypeArguments()).forEach(System.out::println);
        System.out.println("interfaces == ");
        Arrays.stream(clazz.getInterfaces()).forEach(System.out::println);
        System.out.println("getGenericInterfaces == ");
        Arrays.stream(clazz.getGenericInterfaces()).forEach(System.out::println);

//        AnnotatedElementUtils.findMergedAnnotation(GenericDemo.class, Component.class);

    }

}
