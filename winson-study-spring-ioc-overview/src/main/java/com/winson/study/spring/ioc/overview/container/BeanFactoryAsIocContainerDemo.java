package com.winson.study.spring.ioc.overview.container;

import com.winson.study.spring.ioc.overview.annotation.Super;
import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import java.util.Map;

/**
 * @author winson
 * @date 2021/6/17
 **/
public class BeanFactoryAsIocContainerDemo {

    public static void main(String[] args) {
        System.out.println("test bean factory as ioc container start ... ");

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:/META-INF/study-spring-ioc-dependency-lookup.xml");

        User user = beanFactory.getBean(User.class);
        System.out.println("user : " + user);
        lookupCollectionByType(beanFactory);
        lookupCollectionByAnnotation(beanFactory);
        System.out.println("test bean factory as ioc container end ... ");
    }

    private static void lookupCollectionByAnnotation(DefaultListableBeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            Map<String, Object> annotationBeanMap = beanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("lookup collection by annotation result : " + annotationBeanMap);
        }
    }

    private static void lookupCollectionByType(DefaultListableBeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = beanFactory;
            Map<String, User> beanUserMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("lookup collection by type result : " + beanUserMap);
        }

    }


}
