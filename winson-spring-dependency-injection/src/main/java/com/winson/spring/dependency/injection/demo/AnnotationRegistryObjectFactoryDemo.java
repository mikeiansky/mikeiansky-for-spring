package com.winson.spring.dependency.injection.demo;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2022/3/13
 **/
public class AnnotationRegistryObjectFactoryDemo implements ObjectFactory<AnnotationRegistryObjectFactoryDemo.Hello> {

    public static class Hello{

    }

    @Override
    public Hello getObject() throws BeansException {
        System.out.println("getObject ===> ");
        return new Hello();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationRegistryObjectFactoryDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String resourcePath = "classpath:/winson-spring-overview.xml";
        reader.loadBeanDefinitions(resourcePath);

        context.refresh();

        AnnotationRegistryObjectFactoryDemo demo = context.getBean(AnnotationRegistryObjectFactoryDemo.class);
        System.out.println(demo);
        System.out.println(demo.getObject());

        // object provider 不好影响 FactoryBean的定义
        Hello helloDemo = context.getBean(Hello.class);
        System.out.println(helloDemo);

    }

}
