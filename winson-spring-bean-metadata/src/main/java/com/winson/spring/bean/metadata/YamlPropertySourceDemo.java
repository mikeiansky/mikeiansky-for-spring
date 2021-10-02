package com.winson.spring.bean.metadata;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author winson
 * @date 2021/10/2
 **/
@Configuration
@PropertySource(name = "winson-yaml",value = "classpath:/META-INF/winson.yaml", factory = WinsonYamlPropertySourceFactory.class)
//@PropertySource("classpath:/META-INF/winson.properties")
public class YamlPropertySourceDemo {

    @Value("${winson.name}")
    private String name;

    @Value("${winson.age}")
    private int age;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(YamlPropertySourceDemo.class);

        context.refresh();

        YamlPropertySourceDemo demo = context.getBean(YamlPropertySourceDemo.class);
        System.out.println(demo);
        System.out.println(demo.name);
        System.out.println(demo.age);

        context.close();
    }

}
