package io.github.mikeiansky.spring.v6.overview.context.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author mike ian
 * @date 2024/12/10
 * @desc
 **/
public class AutowireContextDemo {

    public static class One {
        @Autowired
        private Two two;

        public Two getTwo() {
            return two;
        }
    }

    public static class Two {
        @Autowired
        private One one;

        public One getOne() {
            return one;
        }
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(One.class, Two.class);
        context.refresh();

        One one = context.getBean(One.class);
        Two two = context.getBean(Two.class);
        System.out.println("one is " + one);
        System.out.println("two is " + two);
        System.out.println("one of two is " + two.getOne());
        System.out.println("two of one is " + one.getTwo());

    }

}
