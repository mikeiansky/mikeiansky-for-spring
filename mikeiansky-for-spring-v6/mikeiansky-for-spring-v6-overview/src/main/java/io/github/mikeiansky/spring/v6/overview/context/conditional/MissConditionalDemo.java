package io.github.mikeiansky.spring.v6.overview.context.conditional;

import io.github.mikeiansky.spring.v6.overview.conditional.UseConditional;
import io.github.mikeiansky.utils.CollKit;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author mike ian
 * @date 2024/12/16
 * @desc
 **/
public class MissConditionalDemo {

    @UseConditional(CollKit.class)
    @Configuration
    public static class MissBeanConfig {

    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MissBeanConfig.class);
        context.register(MissBeanConfig.class);
        MissBeanConfig missBeanConfig = context.getBean(MissBeanConfig.class);
        System.out.println(missBeanConfig);

    }

}
