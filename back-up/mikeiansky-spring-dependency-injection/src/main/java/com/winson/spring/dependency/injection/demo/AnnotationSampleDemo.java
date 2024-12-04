package com.winson.spring.dependency.injection.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

/**
 * @author winson
 * @date 2022/3/20
 **/
@Lazy
@Primary
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
@Description("test-demo")
@DependsOn({"two", "one"})
@Qualifier("demo")
@Configuration
public class AnnotationSampleDemo {

    public AnnotationSampleDemo() {
        System.out.println("AnnotationSampleDemo init");
    }

    @Bean
    public static String one() {
        System.out.println("one bean init");
        return "one";
    }

    @Bean
//    public String two(){ // 不行
    public static String two() {
        System.out.println("two bean init");
        return "two";
    }

    @Bean
    public String three() {
        System.out.println("three bean init");
        return "three";
    }

    @Bean
    @Lazy(value = false)
    public String four() {
        System.out.println("four bean init");
        return "four";
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationSampleDemo.class);
        System.out.println("===== refresh start");
        context.refresh();
        System.out.println("===== refresh complete");
//        System.out.println(context.getBean(AnnotationSampleDemo.class));
//        System.out.println(context.getBean("one"));
//        System.out.println(context.getBean("two"));
//        System.out.println(context.getBean("three"));

        context.close();

    }

}
