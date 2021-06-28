package com.winson.study.spring.configuration.metadata;

import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author winson
 * @date 2021/6/28
 **/
public class ExtensibleXmlDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/user-context.xml");
        System.out.println(beanFactory.getBeansOfType(User.class));
        User user = beanFactory.getBean(User.class);
        System.out.println("user bean : " + user);
        System.out.println("id[67] user bean : " + beanFactory.getBean("67", User.class));

    }

}
