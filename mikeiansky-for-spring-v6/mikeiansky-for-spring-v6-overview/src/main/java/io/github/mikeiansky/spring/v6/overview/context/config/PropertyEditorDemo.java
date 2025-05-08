package io.github.mikeiansky.spring.v6.overview.context.config;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author mike ian
 * @date 2025/5/8
 * @desc
 **/
public class PropertyEditorDemo {

    @Configuration
    public static class AppConfig {

    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getBeanFactory().addPropertyEditorRegistrar(new PropertyEditorRegistrar() {

            @Override
            public void registerCustomEditors(PropertyEditorRegistry registry) {
                System.out.println("registerCustomEditors :: " + registry);
            }
        });
        context.register(AppConfig.class);
        context.refresh();

        AppConfig appConfig = context.getBean(AppConfig.class);
        System.out.println(appConfig);

    }

}
