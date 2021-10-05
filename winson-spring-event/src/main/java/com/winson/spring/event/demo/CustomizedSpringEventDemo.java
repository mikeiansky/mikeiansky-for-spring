package com.winson.spring.event.demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;

/**
 * @author winson
 * @date 2021/10/5
 **/
public class CustomizedSpringEventDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CustomizedSpringEventDemo.class);
        context.addApplicationListener(new MySpringEventListener());
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println("event : " + event);
            }
        });

        context.refresh();
        context.start();

        context.publishEvent(new MySpringEvent("hello event"));

        context.close();

    }

    @EventListener
    public void onStart(ContextRefreshedEvent event){
        System.out.println("on refresh event : " + event);
    }

    @EventListener
    public void onStart(ContextStartedEvent event){
        System.out.println("on start event : " + event);
    }

    @EventListener
    public void onStart(ContextClosedEvent event){
        System.out.println("on close event : " + event);
    }


}
