package com.winson.study.spring.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/6/21
 **/
public class ResolvableDependencyDemo {

    @Autowired
    private String value;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ResolvableDependencyDemo.class);

        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.registerResolvableDependency(String.class, "hello,world");
        });

        applicationContext.refresh();

        ResolvableDependencyDemo demo = applicationContext.getBean(ResolvableDependencyDemo.class);
        System.out.println(demo.value);


        applicationContext.close();
    }

}
