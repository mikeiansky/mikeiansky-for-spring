package com.winson.spring.event.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @author winson
 * @date 2021/10/5
 **/
public class InjectionEventDemo implements ApplicationContextAware, ApplicationEventPublisherAware {

    private ApplicationContext applicationContext;

    private ApplicationEventPublisher applicationEventPublisher;

    @PostConstruct
    public void onPostConstruct(){
        applicationEventPublisher.publishEvent(new MySpringEvent("onPostConstruct # applicationEventPublisher"));
        applicationContext.publishEvent(new MySpringEvent("onPostConstruct # applicationContext"));
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(InjectionEventDemo.class);
        context.addApplicationListener(new MySpringEventListener());
        context.refresh();

        context.close();

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        this.applicationEventPublisher.publishEvent(new MySpringEvent("setApplicationContext"));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
        applicationEventPublisher.publishEvent(new MySpringEvent("setApplicationEventPublisher"));
    }

}
