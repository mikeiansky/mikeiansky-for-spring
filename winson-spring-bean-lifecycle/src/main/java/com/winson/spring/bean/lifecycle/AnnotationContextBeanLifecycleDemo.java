package com.winson.spring.bean.lifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class AnnotationContextBeanLifecycleDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Temp.class);
        BeanFactory beanFactory = context.getBeanFactory();
        System.out.println("beanFactory : " + beanFactory);
        context.refresh();
        System.out.println("after refresh === ");
        beanFactory = context.getBeanFactory();
        System.out.println("beanFactory : " + beanFactory);

        Temp temp = context.getBean(Temp.class);
        System.out.println(temp);

        context.close();
    }

}
