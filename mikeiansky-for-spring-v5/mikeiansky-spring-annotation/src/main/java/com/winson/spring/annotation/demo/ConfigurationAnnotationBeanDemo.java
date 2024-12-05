package com.winson.spring.annotation.demo;

import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author winson
 * @date 2022/4/26
 **/
public class ConfigurationAnnotationBeanDemo {

    @Bean
    public String winsonName(){
        return "winson";
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();


        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(String.class);
        context.registerBeanDefinition("ciwei-haha",genericBeanDefinition);

        context.register(ConfigurationAnnotationBeanDemo.class);

        context.refresh();
        String winsonName = context.getBean("winsonName", String.class);
        System.out.println(winsonName);

    }

}
