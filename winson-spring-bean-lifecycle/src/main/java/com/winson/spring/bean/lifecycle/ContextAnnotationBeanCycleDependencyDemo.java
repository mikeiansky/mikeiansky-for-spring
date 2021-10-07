package com.winson.spring.bean.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/10/1
 **/
public class ContextAnnotationBeanCycleDependencyDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(CycleOne.class);
        context.register(CycleTwo.class);

        context.refresh();

        CycleOne one = context.getBean(CycleOne.class);
        CycleTwo two = context.getBean(CycleTwo.class);
        System.out.println("==== one ====");
        System.out.println("one : " + one);
        System.out.println("one.getCycleTwo() : " + one.getCycleTwo());
        System.out.println("==== two ====");
        System.out.println("two : " + one);
        System.out.println("two.getCycleTwo() : " + two.getCycleOne());

    }

}
