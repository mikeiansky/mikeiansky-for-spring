package com.winson.spring.dependency.lookup.demo;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author winson
 * @date 2021/9/25
 **/
public class BeanProviderDemoV2 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config.class);
        context.refresh();

        ObjectProvider<String> objectProvider = context.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
        System.out.println("|----------------|");
        objectProvider.stream().forEach(System.out::println);
        System.out.println("|================|");
//        System.out.println(context.getBean(String.class));

    }

    @Configuration
    public static class Config{

        @Bean
        @Primary
        public String hello(){
            return "hello world";
        }

        @Bean
        public String hello2(){
            return "hello world 2 ";
        }

        @Bean
        public String hello3(){
            return "hello world 3 ";
        }

    }

}
