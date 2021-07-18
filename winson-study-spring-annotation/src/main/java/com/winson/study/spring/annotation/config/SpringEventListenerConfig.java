package com.winson.study.spring.annotation.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author winson
 * @date 2021/7/18
 **/
@Configuration
public class SpringEventListenerConfig implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("receive application event : " + event);
    }

}
