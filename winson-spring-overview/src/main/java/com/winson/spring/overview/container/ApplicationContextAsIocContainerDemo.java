package com.winson.spring.overview.container;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author winson
 * @date 2021/9/23
 **/
public class ApplicationContextAsIocContainerDemo {


    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        String xmlPath = "classpath:/winson-spring-overview.xml";
        Resource resource = new ClassPathResource(xmlPath);
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        int beanDefinitionCount = reader.loadBeanDefinitions(xmlPath);
        System.out.println("load bean count : " + beanDefinitionCount);

    }

}
