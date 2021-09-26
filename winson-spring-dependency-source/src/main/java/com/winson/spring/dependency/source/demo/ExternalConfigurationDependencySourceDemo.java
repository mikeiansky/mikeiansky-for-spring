package com.winson.spring.dependency.source.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * @author winson
 * @date 2021/9/26
 **/
@Configuration
@PropertySource(value = "classpath:/default-source.properties", encoding = "utf-8")
public class ExternalConfigurationDependencySourceDemo {

    @Value("${user.id:-1}")
    private int id;

    @Value("${user.alias:test}")
    private String alias;

    @Value("${user.resource:classpath://test.properties}")
    private Resource resource;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ExternalConfigurationDependencySourceDemo.class);
        context.refresh();

        ExternalConfigurationDependencySourceDemo demo = context.getBean(ExternalConfigurationDependencySourceDemo.class);
        System.out.println(demo.id);
        System.out.println(demo.alias);
        System.out.println(demo.resource);

        context.close();

    }

}
