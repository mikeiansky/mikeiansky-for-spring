package io.github.mikeiansky.spring.v6.overview.context.conditional;

import io.github.mikeiansky.spring.v6.overview.conditional.BaseConditional;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Conditional;

/**
 * @author mike ian
 * @date 2024/12/10
 * @desc
 **/
@Conditional(BaseConditional.class)
public class AnnotationContextConditionalDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationContextConditionalDemo.class);
        context.refresh();

        AnnotationContextConditionalDemo demo = context.getBean(AnnotationContextConditionalDemo.class);
        System.out.println("demo = " + demo);

    }

}
