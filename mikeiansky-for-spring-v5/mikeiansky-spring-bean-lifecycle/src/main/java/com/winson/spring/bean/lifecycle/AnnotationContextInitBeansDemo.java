package com.winson.spring.bean.lifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class AnnotationContextInitBeansDemo {

    @Autowired
    private BeanFactory beanFactory;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(AnnotationContextInitBeansDemo.class);
//        context.getBeanFactory().registerSingleton("winson", "winson");

        context.refresh();
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        System.out.println("common ========");
        System.out.println(context.getBean("org.springframework.context.annotation.internalConfigurationAnnotationProcessor"));
        System.out.println(context.getBean("org.springframework.context.annotation.internalAutowiredAnnotationProcessor"));
        System.out.println(context.getBean("org.springframework.context.annotation.internalCommonAnnotationProcessor"));
        System.out.println(context.getBean("org.springframework.context.event.internalEventListenerProcessor"));
        System.out.println(context.getBean("org.springframework.context.event.internalEventListenerFactory"));
        // error
//        System.out.println(context.getBean(BeanFactory.class));

        System.out.println("inject1 ========= ");
        ObjectProvider<Temp> tempObjectProvider = context.getBeanProvider(Temp.class);
        System.out.println(tempObjectProvider.getIfAvailable());
        System.out.println("inject2 ========= ");
        context.register(Temp.class);
        System.out.println(tempObjectProvider.getIfAvailable());

    }

}
