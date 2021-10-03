package com.winson.spring.dependency.source.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/10/3
 **/
public class AnnotationContextDemo {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(Temp.class);

        context.refresh();

        Temp temp = context.getBean(Temp.class);
        System.out.println("temp : " + temp);
        System.out.println("temp : " + temp.address);

        context.close();

    }

}
