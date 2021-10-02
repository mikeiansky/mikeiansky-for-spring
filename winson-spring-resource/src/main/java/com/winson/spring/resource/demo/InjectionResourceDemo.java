package com.winson.spring.resource.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import java.util.Arrays;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class InjectionResourceDemo {

    @Value("classpath:/META-INF/winson.properties")
    private Resource resource;

    @Value("classpath*:/META-INF/*.properties")
    private Resource[] multiResource;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(InjectionResourceDemo.class);
        context.refresh();

        InjectionResourceDemo demo = context.getBean(InjectionResourceDemo.class);

        System.out.println("demo : " + demo);
        System.out.println("demo.resource : " + demo.resource);
        System.out.println("demo.multiResource : " + demo.multiResource);
//        System.out.println(demo.age);
        System.out.println("====== 1");
        System.out.println(ResourceUtils.getContent(demo.resource));
        System.out.println("====== 2");
        Arrays.stream(demo.multiResource).map(ResourceUtils::getContent).forEach(System.out::println);

        context.close();

    }

}
