package com.winson.study.spring.annotation.demo.ioc;

import com.winson.study.spring.annotation.config.PostProcessConfig;
import com.winson.study.spring.annotation.utils.ContextUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author winson
 * @date 2021/7/16
 **/
public class BeanPostProcessDemo {


    public static void method1(){
        System.out.println("this is method1");
    }

    public static void method2(){
        System.out.println("this is method1");
        method3();
    }

    public static void method3(){
        System.out.println("this is method1");
    }

    public static void main(String[] args) {
        method1();
        method2();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PostProcessConfig.class);
//        ContextUtils.printBeans(context);
        Environment environment = context.getEnvironment();
        System.out.println(environment.getProperty("winson"));

        context.close();

    }

}
