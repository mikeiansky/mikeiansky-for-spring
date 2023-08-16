package com.winson.spring.aop.overview;

/**
 * @author winson
 * @date 2021/10/8
 **/
public class ClassloadingDemo {

    public static void main(String[] args) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        ClassLoader currentClassLoader = classLoader;
        while (currentClassLoader.getParent() != null){
            currentClassLoader = currentClassLoader.getParent();
            System.out.println(currentClassLoader);
        }

    }

}
