package com.winson.study.spring.ioc.overview.container;

import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author winson
 * @date 2021/6/17
 **/
@Configuration
public class AnnotationApplicationContextAsIocContainerDemo {

    @Bean
    public void getVoid(){

    }

    @Bean
    public User user(){
        User user = new User();
        user.setName("winson-study");
        user.setAge(8);
        return user;
    }

    public static void main(String[] args) {
        System.out.println("test annotation application context as ioc container demo start ... ");

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);
        applicationContext.refresh();

        User user = applicationContext.getBean(User.class);
        System.out.println("annotation get user bean : " + user);

        System.out.println("annotation get void bean : " + applicationContext.getBean("getVoid"));

        applicationContext.close();

        System.out.println("test annotation application context as ioc container demo end ...");
    }

}
