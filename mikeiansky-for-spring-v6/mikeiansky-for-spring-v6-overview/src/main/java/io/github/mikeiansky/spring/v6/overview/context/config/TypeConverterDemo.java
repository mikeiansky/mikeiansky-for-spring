package io.github.mikeiansky.spring.v6.overview.context.config;

import org.springframework.beans.SimpleTypeConverter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author mike ian
 * @date 2025/5/8
 * @desc
 **/
public class TypeConverterDemo {

    @Configuration
    public static class AppConfig {

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getBeanFactory().setTypeConverter(new SimpleTypeConverter());
        context.register(AppConfig.class);
        context.refresh();

        AppConfig appConfig = context.getBean(AppConfig.class);
        System.out.println(appConfig);
    }

}
