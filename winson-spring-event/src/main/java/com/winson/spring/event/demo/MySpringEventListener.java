package com.winson.spring.event.demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author winson
 * @date 2021/10/5
 **/
public class MySpringEventListener implements ApplicationListener<MySpringEvent> {

    @Override
    public void onApplicationEvent(MySpringEvent event) {
        System.out.println(Thread.currentThread().getName() + " onApplicationEvent , event : " + event.getSource());
    }

}
