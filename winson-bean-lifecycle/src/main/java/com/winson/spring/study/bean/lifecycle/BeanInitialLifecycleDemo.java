package com.winson.spring.study.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2021/6/26
 **/
public class BeanInitialLifecycleDemo {

    public static void main(String[] args) {
        executeWithBeanFactory();
    }


    private static void executeWithBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String[] resources = {"META-INF/study-spring-ioc-dependency-lookup.xml",
                "META-INF/bean-constructor-dependency-injection.xml"};
        int loadBeanCount = reader.loadBeanDefinitions(resources);
        System.out.println("通过 resource 方式 load 的bean的数量是 ：" + loadBeanCount);
        System.out.println(beanFactory.getBean("user"));
        System.out.println(beanFactory.getBean("superUser"));
        System.out.println(beanFactory.getBean("userHolder"));
    }


}
