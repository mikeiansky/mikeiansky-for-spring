package com.winson.spring.bean.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2021/9/24
 **/
public class BeanAliasDemo {

    public static void main(String[] args) {

        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:/bean-definitions-context.xml");
        System.out.println(beanFactory.getBean("winson-user"));

    }

}
