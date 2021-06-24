package com.winson.spring.study.bean.lifecycle;

import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2021/6/24
 **/
public class BeanLifecycleDemo {

    public static void main(String[] args) {

        String resource = "classpath:/META-INF/study-spring-ioc-dependency-lookup.xml";

        DefaultListableBeanFactory context = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        int beanNum = reader.loadBeanDefinitions(resource);
        System.out.println("加载bean的数量：" + beanNum);

    }

}
