package com.winson.study.spring.beans.definition;

import com.winson.study.spring.beans.factory.DefaultUserFactory;
import com.winson.study.spring.beans.factory.UserFactory;
import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author winson
 * @date 2021/6/19
 **/
@Configuration
public class BeanInitiationDemoV2 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitiationDemoV2.class);
        applicationContext.refresh();
        applicationContext.close();
    }

    @Bean(initMethod = "initMethod")
    public UserFactory createUser(){
        return new DefaultUserFactory();
    }

}
