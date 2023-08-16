package com.winson.spring.bean.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class AnnotationAutowireContextDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ActionOne.class);
        context.register(ActionTwo.class);

        context.refresh();

        System.out.println(context.getBean(ActionOne.class));
        System.out.println(context.getBean(ActionTwo.class));

        context.close();

    }

}
