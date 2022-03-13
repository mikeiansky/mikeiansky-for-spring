package com.winson.spring.bean.metadata;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.core.env.MapPropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @author winson
 * @date 2021/10/2
 **/
//@Configuration // could config bean as config class for full mode
//@Component // could config bean as config class for lite mode
@PropertySource("classpath:/META-INF/winson.properties")
@WinsonPlaceholderAnnotation("zhou-wen-xiang")
public class PropertySourceDemo implements InitializingBean {

    @Value("${winson.age}")
    private int age;

    @Lazy
    public PropertySourceDemo(){
        System.out.println("PropertySourceDemo init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PropertySourceDemo ===> afterPropertiesSet");
    }

    @PostConstruct
    public void onPostConstruct(){
        System.out.println("PropertySourceDemo ===> onPostConstruct");
    }

    @Bean
    public TestIf createTestIf(@Value("${winson.age}") String age){
        System.out.println("createTestIf TestIf age : " + age);
        return new TestIf();
    }

    @Bean
    public TestIf createTestIfWithTwo(@Value("${winson.age}") String age, @Value("${winson.address}") String address){
        System.out.println("createTestIfWithTwo TestIf age : " + age);
        return new TestIf();
    }

    @Bean
    public static TestIf createTestUseStatic(@Value("${winson.age}") String age){
        System.out.println("TestIf createTestUseStatic age : " + age);
        return new TestIf();
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(PropertySourceDemo.class);

//        HashMap<String,Object> sourceMap = new HashMap<>();
//        sourceMap.put("age", 44);
//        MapPropertySource mapPropertySource = new MapPropertySource("haha",sourceMap);
//        context.getEnvironment().getPropertySources().addFirst(mapPropertySource);
        System.out.println("refresh --- start");
        context.refresh();
        System.out.println("refresh --- end");

        PropertySourceDemo demo = context.getBean(PropertySourceDemo.class);
        System.out.println(demo);
        System.out.println(demo.age);

        context.close();

    }

}
