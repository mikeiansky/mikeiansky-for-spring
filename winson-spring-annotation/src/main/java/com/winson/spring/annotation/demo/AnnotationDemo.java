package com.winson.spring.annotation.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author winson
 * @date 2021/10/6
 **/
@WinsonAnnotation(winsonName = "wenxiang", winsonAge = 5)
@Configuration(proxyBeanMethods = false, value = "testAnnotation")
public class AnnotationDemo {

    @Autowired
    private OtherDemo otherDemo;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(AnnotationDemo.class);
        context.register(OtherDemo.class);

        context.refresh();

        System.out.println(context.getBean("testAnnotation", AnnotationDemo.class));

        context.close();

    }

}
