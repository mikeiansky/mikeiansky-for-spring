package com.winson.spring.annotation.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/10/6
 **/
@EnableHello
public class EnableModuleDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnableModuleDemo.class);
        context.refresh();

        String hello = context.getBean("hello", String.class);
        System.out.println("hello : " + hello);

        context.close();

    }

}
