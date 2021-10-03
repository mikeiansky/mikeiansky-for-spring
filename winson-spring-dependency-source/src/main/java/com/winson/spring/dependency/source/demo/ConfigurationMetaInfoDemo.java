package com.winson.spring.dependency.source.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author winson
 * @date 2021/10/3
 **/
@Configuration
public class ConfigurationMetaInfoDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConfigurationMetaInfoDemo.class);
        context.refresh();
        ConfigurationMetaInfoDemo demo = context.getBean(ConfigurationMetaInfoDemo.class);
        System.out.println(demo);
        context.close();

    }

}
