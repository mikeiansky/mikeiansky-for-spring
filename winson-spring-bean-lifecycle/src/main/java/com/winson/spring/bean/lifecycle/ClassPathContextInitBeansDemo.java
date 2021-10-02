package com.winson.spring.bean.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class ClassPathContextInitBeansDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.refresh();

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println("======");
//        System.out.println(context.getBean("systemProperties"));

    }

}
