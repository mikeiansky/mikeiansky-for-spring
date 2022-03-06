package com.winson.spring.utils;

import org.springframework.core.ResolvableType;

/**
 * @author winson
 * @date 2022/3/5
 **/
public class ResolvableTypeDemo {

    public void sayHello(String msg){
        System.out.println("ResolvableTypeDemo sayHello : " + msg);
    }

    public static void main(String[] args) {

        ResolvableType type = ResolvableType.forClass(ResolvableTypeDemo.class);
        System.out.println("type.getRawClass() :"+type.getRawClass());
        System.out.println("type.getSuperType() :"+type.getSuperType());
        System.out.println("type.getComponentType() :"+type.getComponentType());
        System.out.println("type.getInterfaces().length :"+type.getInterfaces().length);

    }

}
