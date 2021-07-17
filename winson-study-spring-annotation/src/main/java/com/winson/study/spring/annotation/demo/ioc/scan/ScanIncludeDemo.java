package com.winson.study.spring.annotation.demo.ioc.scan;

import com.winson.study.spring.annotation.config.ScanIncludeConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author winson
 * @date 2021/7/15
 **/
public class ScanIncludeDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanIncludeConfig.class);
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(System.out::println);

    }

}
