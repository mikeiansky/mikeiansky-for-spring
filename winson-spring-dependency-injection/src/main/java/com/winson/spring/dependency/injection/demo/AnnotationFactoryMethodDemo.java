package com.winson.spring.dependency.injection.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @author winson
 * @date 2022/3/20
 **/
//@Lazy
public class AnnotationFactoryMethodDemo {

    public AnnotationFactoryMethodDemo() {
        System.out.println("create annotation factory method demo!");
    }

    @Bean
    public String helloOne(){
        System.out.println("create hello one");
        return "hello-one";
    }

//    @Lazy
    @Bean
    public static String helloTwo(){
        System.out.println("create hello two");
        return "hello-two";
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationFactoryMethodDemo.class);

        context.refresh();

        context.close();

    }

}
