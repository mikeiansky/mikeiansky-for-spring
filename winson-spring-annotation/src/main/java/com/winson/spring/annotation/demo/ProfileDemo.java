package com.winson.spring.annotation.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;

/**
 * @author winson
 * @date 2021/10/6
 **/
public class ProfileDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.getEnvironment().setDefaultProfiles("even");
        context.getEnvironment().setDefaultProfiles("odd");
        context.register(ProfileDemo.class);
//        context.getEnvironment().acceptsProfiles("even");
        context.refresh();

        int number = context.getBean(int.class);
        System.out.println("number : " + number);

        context.close();

    }

    @Bean
//    @Profile("even")
    @Conditional(EvenProfileCondition.class)
    public int even() {
        return 2;
    }

    @Bean
//    @Profile("odd")
    @Conditional(OddProfileCondition.class)
    public int odd() {
        return 1;
    }

}
