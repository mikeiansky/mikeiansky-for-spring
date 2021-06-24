package com.winson.spring.study.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @author winson
 * @date 2021/6/24
 **/
public class MergedBeanDefinitionDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        Resource resource = new ClassPathResource("META-INF/study-spring-ioc-dependency-lookup.xml");
        EncodedResource encodedResource = new EncodedResource(resource, "utf-8");
        int loadBeanCount = reader.loadBeanDefinitions(encodedResource);
        System.out.println("通过 resource 方式 load 的bean的数量是 ：" + loadBeanCount);

        System.out.println(beanFactory.getBean("user"));
        System.out.println(beanFactory.getBean("superUser"));

    }

}
