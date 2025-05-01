package io.github.mikeiansky.spring.v6.overview.context.base;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author mike ian
 * @date 2025/5/1
 * @desc
 **/
public class OneBeanContextDemo {

    public static class One {

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(One.class);
        context.refresh();
        One bean = context.getBean(One.class);
        System.out.println("one : " + bean);
    }

}
