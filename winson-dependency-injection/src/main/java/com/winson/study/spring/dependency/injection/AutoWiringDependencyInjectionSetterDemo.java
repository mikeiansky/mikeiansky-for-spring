package com.winson.study.spring.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author winson
 * @date 2021/6/20
 **/
public class AutoWiringDependencyInjectionSetterDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String resource = "classpath:/META-INF/dependency-setter-injection.xml";
        reader.loadBeanDefinitions(resource);

    }

}
