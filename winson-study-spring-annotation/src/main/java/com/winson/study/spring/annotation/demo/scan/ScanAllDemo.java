package com.winson.study.spring.annotation.demo.scan;

import com.winson.study.spring.annotation.config.ScanAllConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author winson
 * @date 2021/7/15
 **/
public class ScanAllDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanAllConfig.class);
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(System.out::println);

    }

}
