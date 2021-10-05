package com.winson.spring.event.demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author winson
 * @date 2021/10/5
 **/
@EnableAsync
public class AnnotationAsyncSpringEventDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationAsyncSpringEventDemo.class);
//        context.addApplicationListener(new MySpringEventListener());

        context.refresh();
        context.start();

//        context.publishEvent(new MySpringEvent("hello event"));

        context.close();

    }

    @EventListener
    @Async
    public void onStart(ContextRefreshedEvent event){
        System.out.println(Thread.currentThread().getName() + " , on refresh event : " + event);
    }



}
