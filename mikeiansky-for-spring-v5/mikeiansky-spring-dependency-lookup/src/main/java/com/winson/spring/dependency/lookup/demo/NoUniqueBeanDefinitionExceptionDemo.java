package com.winson.spring.dependency.lookup.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author winson
 * @date 2021/9/25
 **/
public class NoUniqueBeanDefinitionExceptionDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(NoUniqueBeanDefinitionExceptionDemo.class);
        context.refresh();

        System.out.println(context.getBean(String.class));

        context.close();

    }

    @Bean
    public String hello1(){
        return "hello1";
    }

    @Bean
    public String hello2(){
        return "hello1";
    }

    @Bean
    public String hello3(){
        return "hello1";
    }

}
