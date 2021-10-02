package com.winson.spring.resource.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.util.Arrays;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class InjectionResourceLoaderDemo {

    @Autowired
    private ResourceLoader resourceLoader;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(InjectionResourceLoaderDemo.class);
        context.refresh();

        InjectionResourceLoaderDemo demo = context.getBean(InjectionResourceLoaderDemo.class);

        System.out.println("demo : " + demo);
        System.out.println("demo.resource : " + demo.resourceLoader);
//        System.out.println(demo.age);
//        System.out.println("====== 1");
//        System.out.println(ResourceUtils.getContent(demo.resource));
//        System.out.println("====== 2");
//        Arrays.stream(demo.multiResource).map(ResourceUtils::getContent).forEach(System.out::println);
        System.out.println("===1");
        System.out.println(ResourceUtils.getContent(demo.resourceLoader.getResource("META-INF/winson.properties")));
        System.out.println("===2");
        System.out.println(ResourceUtils.getContent(demo.resourceLoader.getResource("META-INF/default.properties")));

        context.close();

    }

}
