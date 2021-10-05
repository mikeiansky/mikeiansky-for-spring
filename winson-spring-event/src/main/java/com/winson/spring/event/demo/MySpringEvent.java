package com.winson.spring.event.demo;

import org.springframework.context.ApplicationEvent;

/**
 * @author winson
 * @date 2021/10/5
 **/
public class MySpringEvent extends ApplicationEvent {


    public MySpringEvent(Object source) {
        super(source);
    }

}
