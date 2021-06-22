package com.winson.study.spring.source;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * @author winson
 * @date 2021/6/21
 **/
public class DependencySourceDemo {

    @Autowired
    public BeanFactory beanFactory;

    @Autowired
    public ResourceLoader resourceLoader;

    @Autowired
    public ApplicationContext applicationContext;

    @Autowired
    public ApplicationEventPublisher applicationEventPublisher;

    @PostConstruct
    private void init(){
        System.out.println(beanFactory);
        System.out.println(beanFactory == ((ConfigurableApplicationContext)applicationContext).getBeanFactory());
        System.out.println(resourceLoader);
        System.out.println(applicationContext);
        System.out.println(applicationEventPublisher);
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(DependencySourceDemo.class);
        applicationContext.refresh();


        applicationContext.close();

    }

}
