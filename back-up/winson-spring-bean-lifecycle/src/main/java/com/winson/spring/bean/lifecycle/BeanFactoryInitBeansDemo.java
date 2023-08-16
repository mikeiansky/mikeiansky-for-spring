package com.winson.spring.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.Arrays;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class BeanFactoryInitBeansDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        Arrays.stream(beanFactory.getBeanDefinitionNames())
                .forEach(System.out::println);

    }

}
