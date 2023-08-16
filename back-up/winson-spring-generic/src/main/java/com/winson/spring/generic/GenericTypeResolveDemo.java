package com.winson.spring.generic;

import org.springframework.core.GenericTypeResolver;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author winson
 * @date 2021/10/4
 **/
public class GenericTypeResolveDemo {

    public static String getString() {
        return null;
    }

    public static StringList getStringList(){
        return null;
    }

    public static ArrayList getArrayList(){
        return null;
    }

    public static ArrayList<String> getArrayListDetail(){
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        displayGeneric("getString", GenericTypeResolveDemo.class, GenericTypeResolveDemo.class);
        displayGeneric("getStringList",GenericTypeResolveDemo.class,  List.class);
        displayGeneric("getArrayList",GenericTypeResolveDemo.class,  List.class);
        displayGeneric("getArrayListDetail",GenericTypeResolveDemo.class,  List.class);
        Map<TypeVariable, Type> result = GenericTypeResolver.getTypeVariableMap(StringList.class);
        System.out.println(result);
    }

    public static void displayGeneric(String methodName, Class clazz, Class genericClazz) throws NoSuchMethodException {
        Method method = clazz.getDeclaredMethod(methodName);
        Class type = GenericTypeResolver.resolveReturnType(method, clazz);
        Class argumentType = GenericTypeResolver.resolveReturnTypeArgument(method, genericClazz);
        System.out.println(methodName + " , return type : " + type + " , return argumentType : " + argumentType);
    }

}
