package com.winson.spring.dependency.lookup.demo;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2021/9/25
 **/
public class BeanProviderDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/winson-spring-overview.xml");

        ObjectProvider<User> objectProvider = context.getBeanProvider(User.class);
        System.out.println(objectProvider);
        System.out.println(objectProvider.getObject());
        objectProvider.stream().forEach(System.out::println);

        ObjectProvider<String> strObjectProvider = context.getBeanProvider(String.class);
        System.out.println(strObjectProvider.getIfAvailable());
        String s1 = strObjectProvider.getIfAvailable(() -> {
            System.out.println("create s1");
            return "hhh1";
        });
        String s2 = strObjectProvider.getIfAvailable(() -> {
            System.out.println("create s2");
            return "hhh2";
        });
        String s3 = strObjectProvider.getIfAvailable();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s1 == s2);

        String s15 = "cc";
        String s16 = "cc";
        System.out.println(s15 == s16);

    }

}
