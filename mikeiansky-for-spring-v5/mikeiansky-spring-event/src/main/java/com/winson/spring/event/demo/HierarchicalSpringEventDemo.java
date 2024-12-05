package com.winson.spring.event.demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author winson
 * @date 2021/10/5
 **/
public class HierarchicalSpringEventDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext parent = new AnnotationConfigApplicationContext();

        parent.addApplicationListener(new ApplicationListener<ApplicationContextEvent>() {
            @Override
            public void onApplicationEvent(ApplicationContextEvent event) {
                System.out.println("parent get event : " + event.getClass().getSimpleName());
            }
        });


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.addApplicationListener(new ApplicationListener<ApplicationContextEvent>() {
            @Override
            public void onApplicationEvent(ApplicationContextEvent event) {
                System.out.println("context get event : " + event.getClass().getSimpleName());
            }
        });

        context.setParent(parent);


        parent.refresh();
        context.refresh();

//        context.publishEvent(new MySpringEvent("from - context"));
//        parent.publishEvent(new MySpringEvent("from - parent"));

    }

//    public static class MyListener extends ApplicationListener<ApplicationEvent>{
//
//    }

}
