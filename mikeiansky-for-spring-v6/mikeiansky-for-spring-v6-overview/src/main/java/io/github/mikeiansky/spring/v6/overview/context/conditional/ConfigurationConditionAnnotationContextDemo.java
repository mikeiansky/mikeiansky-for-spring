package io.github.mikeiansky.spring.v6.overview.context.conditional;

import io.github.mikeiansky.spring.v6.overview.conditional.MyConfigCondition;
import lombok.Data;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author mike ian
 * @date 2024/12/17
 * @desc
 **/
public class ConfigurationConditionAnnotationContextDemo {

    @Conditional(MyConfigCondition.class)
    @Configuration
    @Data
    public static class One {

    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(One.class);
        context.refresh();

        One one = context.getBean(One.class);
        System.out.println(one);

    }

}
