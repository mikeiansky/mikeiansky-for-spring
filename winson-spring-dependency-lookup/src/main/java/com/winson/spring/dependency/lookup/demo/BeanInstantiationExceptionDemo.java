package com.winson.spring.dependency.lookup.demo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author winson
 * @date 2021/9/25
 **/
public class BeanInstantiationExceptionDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(BeanInstantiationExceptionDemo.class);
//        context.register(CharSequence.class);

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(CharSequence.class);

        context.registerBeanDefinition("errorBean", beanDefinitionBuilder.getBeanDefinition());

        context.refresh();

        context.close();

    }

    @Bean
    public String hello() throws Exception {
        boolean test = true;
        if(test){
            throw new Exception("hello create exception");
        }
        return "hello1";
    }

}
