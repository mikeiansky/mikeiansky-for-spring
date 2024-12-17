package io.github.mikeiansky.spring.v6.overview.context.conditional;

import io.github.mikeiansky.spring.v6.overview.conditional.MissClassConditional;
import io.github.mikeiansky.utils.CollKit;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author mike ian
 * @date 2024/12/16
 * @desc
 **/
public class MissClassConditionalDemo {

    @MissClassConditional(CollKit.class)
    @Configuration
    public static class MissBeanConfig {

    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MissBeanConfig.class);
        context.register(MissBeanConfig.class);
        MissBeanConfig missBeanConfig = context.getBean(MissBeanConfig.class);
        System.out.println(missBeanConfig);

        MissClassConditional useConditional = MissBeanConfig.class.getAnnotation(MissClassConditional.class);
        System.out.println(useConditional);
//        System.out.println(useConditional.value());

    }

}
