package com.winson.spring.bean.metadata;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.MapPropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author winson
 * @date 2021/10/2
 **/
//@Configuration // could config bean as config class for full mode
//@Component // could config bean as config class for lite mode
@PropertySource("classpath:/META-INF/winson.properties")
@WinsonPlaceholderAnnotation("zhou-wen-xiang")
public class PropertySourceDemo {

    @Value("${winson.age}")
    private int age;

    @Bean
    public TestIf createTestIf(@Value("${winson.age}") String age){
        System.out.println("TestIf age : " + age);
        return new TestIf();
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(PropertySourceDemo.class);

//        HashMap<String,Object> sourceMap = new HashMap<>();
//        sourceMap.put("age", 44);
//        MapPropertySource mapPropertySource = new MapPropertySource("haha",sourceMap);
//        context.getEnvironment().getPropertySources().addFirst(mapPropertySource);

        context.refresh();

        PropertySourceDemo demo = context.getBean(PropertySourceDemo.class);
        System.out.println(demo);
        System.out.println(demo.age);

        context.close();

    }

}
