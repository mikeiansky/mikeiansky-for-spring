package io.github.mikeiansky.spring.v6.overview.context.base;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;

/**
 * @author mike ian
 * @date 2024/12/10
 * @desc
 **/
public class ConstructSelfBeanContextDemo {

    public static class One {

        private final One parent;

        // 如果不加lazy会报错
        public One(@Lazy One parent) {
//        public One(One parent) {
            this.parent = parent;
        }

        public void hello(){
            System.out.println("one say hello");
        }

    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(One.class);
        context.refresh();

        One oneBean = context.getBean(One.class);
        System.out.println(oneBean);
        System.out.println(oneBean.parent);
        oneBean.parent.hello();
    }

}
