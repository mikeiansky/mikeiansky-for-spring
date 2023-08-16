package com.winson.spring.dependency.injection.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2021/9/25
 **/
public class AutoWiringByNameDependencyInjectionDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/autowiring-by-name-dependency-setter-injection.xml");

        UserHolder userHolder = context.getBean(UserHolder.class);
        System.out.println(userHolder);

    }

}
