package com.winson.spring.dependency.lookup.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

/**
 * @author winson
 * @date 2021/9/25
 **/
public class BeanCreationExceptionDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanCreationExceptionDemo.class);

        context.refresh();

        context.close();

    }

    @Bean(initMethod = "initMethod")
    public MyBean myBean() {
        return new MyBean();
    }

    public static class MyBean implements InitializingBean {

        @PostConstruct
        public void postConstruct() throws Exception {
//            throw new Exception("postConstruct#exception");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
//            throw new Exception("afterPropertiesSet#exception");
        }

        public void initMethod() throws Exception {
            throw new Exception("initMethod#exception");
        }

    }

}
