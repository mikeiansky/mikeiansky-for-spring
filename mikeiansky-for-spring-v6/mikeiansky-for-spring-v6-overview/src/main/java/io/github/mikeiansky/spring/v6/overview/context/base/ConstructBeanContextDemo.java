package io.github.mikeiansky.spring.v6.overview.context.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author mike ian
 * @date 2024/12/10
 * @desc
 **/
public class ConstructBeanContextDemo {

    public static class One {

    }

    public static class Two {

        public final One one;

        public Two(One one) {
            this.one = one;
        }

        public One getOne() {
            return one;
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(One.class);
        context.register(Two.class);
        context.refresh();

        Two two = context.getBean(Two.class);
        System.out.println(two);
        System.out.println(two.getOne());
    }

}
