package com.winson.spring.bean.lifecycle;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author winson
 * @date 2021/9/27
 **/
public class BeanLifecycleDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        String xmlClassPath = "classpath:/winson-spring-overview.xml";
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(xmlClassPath);
        BeanDefinition superUserBeanDefinition = beanFactory.getBeanDefinition("superUser");

        System.out.println(superUserBeanDefinition.getPropertyValues().size());

        User user = beanFactory.getBean(User.class);

        System.out.println(user);

        System.out.println(beanFactory.getBeanDefinition("user").getPropertyValues().size());


    }

}
