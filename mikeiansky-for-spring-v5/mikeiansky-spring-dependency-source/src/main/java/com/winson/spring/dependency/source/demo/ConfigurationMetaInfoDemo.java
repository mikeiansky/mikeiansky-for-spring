package com.winson.spring.dependency.source.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author winson
 * @date 2021/10/3
 **/
@Configuration
public class ConfigurationMetaInfoDemo {

    @Configuration
    public static class TestEnclosingConfiguration {

    }

    @Configuration
    class NoStaticEnclosingConfiguration {

    }

    private class NoBeanClass {

    }

    public static void main(String[] args) {

        System.out.println(ConfigurationMetaInfoDemo.class.getDeclaringClass());
        System.out.println(TestEnclosingConfiguration.class.getDeclaringClass());
        System.out.println(NoStaticEnclosingConfiguration.class.getDeclaringClass());
        System.out.println("------->");
        for (Class clazz : ConfigurationMetaInfoDemo.class.getDeclaredClasses()) {
            System.out.println("Modifiers: " + clazz.getModifiers() + " , clazz : " + clazz);

        }
        System.out.println("------->");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConfigurationMetaInfoDemo.class);
        context.refresh();

        TestEnclosingConfiguration tc = context.getBean(TestEnclosingConfiguration.class);
        System.out.println("tc : " + tc);
        NoStaticEnclosingConfiguration nc = context.getBean(NoStaticEnclosingConfiguration.class);
        System.out.println("nc : " + nc);
//        NoBeanClass nbc = context.getBean(NoBeanClass.class);
//        System.out.println("nbc : " + nbc);

        ConfigurationMetaInfoDemo demo = context.getBean(ConfigurationMetaInfoDemo.class);
        System.out.println(demo);
        context.close();

    }

}
