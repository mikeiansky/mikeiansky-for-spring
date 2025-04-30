package io.github.mikeiansky.spring.v6.overview.context.base;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;

/**
 * @author mike ian
 * @date 2025/4/30
 * @desc
 **/
public class ContextCircleReferenceDemo {

    public static class One {

        private Two two;

        public One(Two two) {
            this.two = two;
        }
    }

    public static class Two {


        private One one;

        public Two(@Lazy One one) {
            this.one = one;
        }

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(One.class);
        context.register(Two.class);
        context.refresh();

        One one = context.getBean(One.class);
        System.out.println("one : " + one);
        System.out.println("one.two : " + one.two);
        Two two = context.getBean(Two.class);
        System.out.println("two : " + two);
        System.out.println("two.one : " + two.one);

    }

}
