package com.winson.study.spring.annotation.demo.scan;

import com.winson.study.spring.annotation.config.ScanExcludeConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author winson
 * @date 2021/7/15
 **/
public class ScanExcludeDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanExcludeConfig.class);
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(System.out::println);

    }

}
