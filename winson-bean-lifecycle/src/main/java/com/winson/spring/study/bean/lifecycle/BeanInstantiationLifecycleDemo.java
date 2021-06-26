package com.winson.spring.study.bean.lifecycle;

import com.winson.study.spring.ioc.overview.domain.SuperUser;
import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.ObjectUtils;

/**
 * @author winson
 * @date 2021/6/26
 **/
public class BeanInstantiationLifecycleDemo {

    public static void main(String[] args) {
//        executeWithBeanFactory();
        System.out.println("----------------- application context --------------");
        executeWithApplicationContext();
    }

    private static void executeWithApplicationContext() {
        String[] resources = {"META-INF/study-spring-ioc-dependency-lookup.xml",
                "META-INF/bean-constructor-dependency-injection.xml"};

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocations(resources);
        applicationContext.refresh();
        applicationContext.getBeanFactory().addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        System.out.println(applicationContext.getBean("user"));
        System.out.println(applicationContext.getBean("superUser"));
        System.out.println(applicationContext.getBean("userHolder"));

        applicationContext.close();
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
