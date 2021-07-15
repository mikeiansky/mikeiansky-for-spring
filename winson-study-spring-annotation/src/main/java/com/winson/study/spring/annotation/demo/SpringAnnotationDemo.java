package com.winson.study.spring.annotation.demo;

import com.winson.study.spring.annotation.bean.Person;
import com.winson.study.spring.annotation.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author winson
 * @date 2021/7/15
 **/
public class SpringAnnotationDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
//        context.register(MainConfig.class);

        Person person = context.getBean(Person.class);
        System.out.println(person);

        String[] names = context.getBeanNamesForType(Person.class);
        Arrays.stream(names).forEach(System.out::println);

        System.out.println("-------------");

        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(System.out::println);

        Object obj = context.getBean("org.springframework.context.annotation.internalConfigurationAnnotationProcessor");
        System.out.println(obj);

    }

}
