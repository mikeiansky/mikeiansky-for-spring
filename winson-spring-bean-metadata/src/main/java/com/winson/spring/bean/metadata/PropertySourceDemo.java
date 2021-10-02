package com.winson.spring.bean.metadata;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;

/**
 * @author winson
 * @date 2021/10/2
 **/
@Configuration
@PropertySource("classpath:/META-INF/winson.properties")
public class PropertySourceDemo {

    @Value("${age}")
    private int age;

//    @Bean
//    public TestIf createTestIf(@Value("${age}") String age){
//        System.out.println("TestIf age : " + age);
//        return new TestIf();
//    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(PropertySourceDemo.class);

        HashMap<String,Object> sourceMap = new HashMap<>();
        sourceMap.put("age", 44);
        MapPropertySource mapPropertySource = new MapPropertySource("haha",sourceMap);
        context.getEnvironment().getPropertySources().addFirst(mapPropertySource);

        context.refresh();

        PropertySourceDemo demo = context.getBean(PropertySourceDemo.class);
        System.out.println(demo);
        System.out.println(demo.age);

        context.close();

    }

}