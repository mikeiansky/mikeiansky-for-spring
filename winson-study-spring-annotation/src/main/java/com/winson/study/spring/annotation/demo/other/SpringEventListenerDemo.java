package com.winson.study.spring.annotation.demo.other;

import com.winson.study.spring.annotation.config.SpringEventListenerConfig;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/7/18
 **/
public class SpringEventListenerDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringEventListenerConfig.class);

        context.publishEvent("hello");
        context.publishEvent(new ApplicationEvent("winson") {
            @Override
            public Object getSource() {
                return super.getSource();
            }
        });

        context.close();

    }

}
