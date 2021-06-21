package com.winson.study.spring.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * @author winson
 * @date 2021/6/21
 **/
@Configuration
@PropertySource(value = "META-INF/default.properties")
public class ExternalConfigurationDependencySourceDemo {

    @Value("${usr.id:-1}")
    private int id;

    @Value("${usr.name:default}")
    private String name;

    @Value("${usr.resource:classpath://default.properties}")
    private Resource resource;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ExternalConfigurationDependencySourceDemo.class);
        applicationContext.refresh();

        ExternalConfigurationDependencySourceDemo demo = applicationContext.getBean(ExternalConfigurationDependencySourceDemo.class);

        System.out.println(demo.id);
        System.out.println(demo.name);
        System.out.println(demo.resource);

        applicationContext.close();

    }

}
