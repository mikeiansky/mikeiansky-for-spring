package com.winson.spring.utils;

import org.springframework.core.ResolvableType;

import java.lang.reflect.Field;

/**
 * @author winson
 * @date 2022/3/5
 **/
public class ResolvableTypeDemo {

    public String name;

    public void sayHello(String msg){
        System.out.println("ResolvableTypeDemo sayHello : " + msg);
    }

    public static void main(String[] args) throws NoSuchFieldException {

        ResolvableType type = ResolvableType.forClass(ResolvableTypeDemo.class);
        System.out.println("type.getRawClass() :"+type.getRawClass());
        System.out.println("type.getSuperType() :"+type.getSuperType());
        System.out.println("type.getComponentType() :"+type.getComponentType());
        System.out.println("type.getInterfaces().length :"+type.getInterfaces().length);

        Field field = ResolvableTypeDemo.class.getDeclaredField("name");
        System.out.println(ResolvableType.forField(field));
    }

}
