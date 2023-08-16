package com.winson.spring.event.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;

import java.util.Arrays;

/**
 * @author winson
 * @date 2021/10/5
 **/
public class CustomizedSpringEventDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CustomizedSpringEventDemo.class);
        context.addApplicationListener(new MySpringEventListener());
        context.addBeanFactoryPostProcessor(new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                System.out.println("CustomizedSpringEventDemo ==> postProcessBeanFactory :: publish event!");
                context.publishEvent(new MySpringEvent("before spring context refresh event"));
            }
        });
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println("****** event : " + event);
            }
        });
        // error
//        context.publishEvent(new MySpringEvent("before spring context refresh event"));
        context.refresh();
        context.start();

        context.publishEvent(new MySpringEvent("hello event"));
        context.publishEvent(new MySpringEvent(Arrays.asList(1,2,3,4)));

        context.close();

    }

    @EventListener
    public void onRefreshListener(ContextRefreshedEvent event){
        System.out.println("onRefresh event : " + event);
    }

    @EventListener
    public void onStartListener(ContextStartedEvent event){
        System.out.println("onStart event : " + event);
    }

    @EventListener
    public void onCloseListener(ContextClosedEvent event){
        System.out.println("onClose event : " + event);
    }


}
