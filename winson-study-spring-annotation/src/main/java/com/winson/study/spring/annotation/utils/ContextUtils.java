package com.winson.study.spring.annotation.utils;

import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * @author winson
 * @date 2021/7/16
 **/
public class ContextUtils {

    public static void printBeans(ApplicationContext context) {
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(System.out::println);
    }

}
