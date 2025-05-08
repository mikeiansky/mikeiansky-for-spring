package io.github.mikeiansky.spring.v6.overview.context.config;

import io.github.mikeiansky.spring.v6.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

/**
 * @author mike ian
 * @date 2025/5/8
 * @desc
 **/
public class ContextConfigDemo {

    @Component
    public static class InnerConfig {

    }

    @ImportResource(locations = {
//            "file:///C:\\work\\github\\mikeiansky-for\\mikeiansky-for-spring\\mikeiansky-for-spring-v6\\mikeiansky-for-spring-v6-overview\\src\\main\\resources\\mikeiansky-spring-v6-overview.xml",
//            "classpath:mikeiansky-spring-v6-overview.xml",
            "mikeiansky-spring-v6-overview.xml",
    })
    @Configuration
    public static class AppConfig {

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        AppConfig appConfig = context.getBean(AppConfig.class);
        System.out.println(appConfig);

//        AppConfig.InnerConfig innerConfig = context.getBean(AppConfig.InnerConfig.class);
//        System.out.println(innerConfig);

        User user = context.getBean(User.class);
        System.out.println(user);


    }

}
