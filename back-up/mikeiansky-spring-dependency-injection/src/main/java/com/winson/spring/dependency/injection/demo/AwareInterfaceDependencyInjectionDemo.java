package com.winson.spring.dependency.injection.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/9/25
 **/
public class AwareInterfaceDependencyInjectionDemo implements ApplicationContextAware {

    public ApplicationContext applicationContext;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AwareInterfaceDependencyInjectionDemo.class);
        context.refresh();

        AwareInterfaceDependencyInjectionDemo demo = context.getBean(AwareInterfaceDependencyInjectionDemo.class);
        System.out.println(demo.applicationContext);
        System.out.println(context);
        System.out.println(context == demo.applicationContext);

        context.close();

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
