package io.github.mikeiansky.spring.v6.overview.context.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * @author mike ian
 * @date 2025/5/8
 * @desc
 **/
public class ContextPropertyResourceDemo {

    @Data
    @PropertySource(
            value = "classpath:test.properties"
    )
    @Configuration
    public static class AppConfig {

//        @Value("${mikeiansky.tag.version:test}")
//        private String tag;

//        @Value("hello:version")
//        private String version;

//        @Value("${mikeiansky.person}")
        @Value("one,two,three")
//        @Value("#{'one,two,three'.split(',')}")
//        @Value("#{'one:two,three'.split(',')}")
        private List<String> person;

    }

    public static void main(String[] args) {

        // PropertyResource
        // TypeConverter SimpleTypeConverter
        // DependencyAnalyse

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        AppConfig appConfig = context.getBean(AppConfig.class);
        System.out.println(appConfig);
        System.out.println(appConfig.person.size());

    }

}
