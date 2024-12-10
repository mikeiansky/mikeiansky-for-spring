package io.github.mikeiansky.spring.v6.overview.context.base;

import io.github.mikeiansky.spring.v6.overview.conditional.BaseConditional;
import io.github.mikeiansky.spring.v6.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * @author mike ian
 * @date 2024/12/5
 * @desc
 **/
public class AnnotationContextBaseDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationContextBaseDemo.class);
        context.refresh();

        AnnotationContextBaseDemo demo = context.getBean(AnnotationContextBaseDemo.class);
        System.out.println(demo);

    }

}
