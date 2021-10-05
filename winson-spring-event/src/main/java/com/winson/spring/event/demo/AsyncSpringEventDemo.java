package com.winson.spring.event.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.*;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author winson
 * @date 2021/10/5
 **/
public class AsyncSpringEventDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AsyncSpringEventDemo.class);

        context.addApplicationListener(new MySpringEventListener());

        context.refresh();

        ApplicationEventMulticaster listener = context.getBean(AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME, ApplicationEventMulticaster.class);
        if(SimpleApplicationEventMulticaster.class.isAssignableFrom(listener.getClass())){
            ExecutorService executor = Executors.newSingleThreadExecutor();
            SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = (SimpleApplicationEventMulticaster) listener;
            simpleApplicationEventMulticaster.setTaskExecutor(executor);
            context.addApplicationListener((ApplicationListener<ContextClosedEvent>) event -> {
                if(!executor.isShutdown()){
                    executor.shutdown();
                }
            });
        }

        context.publishEvent(new MySpringEvent("hello event"));

        context.close();

    }



}
