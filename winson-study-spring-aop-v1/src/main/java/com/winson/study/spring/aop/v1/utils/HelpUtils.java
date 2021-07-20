package com.winson.study.spring.aop.v1.utils;

import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * @author winson
 * @date 2021/7/19
 **/
public class HelpUtils {

    public static void printlnBeanNames(ApplicationContext context){
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

}
