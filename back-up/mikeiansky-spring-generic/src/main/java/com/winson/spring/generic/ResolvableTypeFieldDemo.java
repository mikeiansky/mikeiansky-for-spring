package com.winson.spring.generic;

import org.springframework.core.ResolvableType;

import java.lang.reflect.Field;

/**
 * @author winson
 * @date 2022/3/6
 **/
public class ResolvableTypeFieldDemo<T> {

    public static String appStaticName;

    public T appName;

    public String age;

    public static void main(String[] args) throws NoSuchFieldException {
        Class clazz = ResolvableTypeFieldDemo.class;
        Field appNameField = clazz.getField("appName");
        Field appStaticNameField = clazz.getField("appStaticName");
        Field ageField = clazz.getField("age");
//        Field noneField = clazz.getField("none");
        System.out.println("appNameField : " + appNameField);
        System.out.println("appStaticNameField : " + appStaticNameField);
        System.out.println("ageField : " + ageField);
//        System.out.println("noneField : " + noneField);

//        ResolvableType rt = ResolvableType.forField(appStaticNameField);
//        ResolvableType rt = ResolvableType.forField(appNameField);
        ResolvableType rt = ResolvableType.forField(ageField);
        System.out.println("rt.getType() : " + rt.getType());
        System.out.println("rt.getClass() : " + rt.getClass());
        System.out.println("rt.getSource() : " + rt.getSource());
        System.out.println("rt.getSource().getClass() : " + rt.getSource().getClass());
        System.out.println("rt.getSuperType() : " + rt.getSuperType());
        System.out.println("rt.getComponentType() : " + rt.getComponentType());
        System.out.println("rt.getInterfaces() : " + rt.getInterfaces().length);
        System.out.println("rt.getGenerics() : " + rt.getGenerics().length);
        System.out.println("rt.getNested(0) : " + rt.getNested(0));
        System.out.println("rt.getNested(1) : " + rt.getNested(1));
        System.out.println("rt.getNested(2) : " + rt.getNested(2));


    }

}
