package com.winson.spring.bean.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/10/1
 **/
public class ContextAnnotationBeanCycleDependencyDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ActionOne.class);
        context.register(ActionTwo.class);

        context.refresh();

        ActionOne one = context.getBean(ActionOne.class);
        System.out.println("==== one ====");
        System.out.println("one : " + one);
        System.out.println("one.getTwo() : " + one.getTwo());
//        System.out.println("==== two ====");
//        System.out.println("two : " + one);
//        System.out.println("two.getTwo() : " + one.getTwo());

    }

}
