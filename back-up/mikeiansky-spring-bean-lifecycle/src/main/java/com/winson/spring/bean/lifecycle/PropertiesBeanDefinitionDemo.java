package com.winson.spring.bean.lifecycle;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Arrays;

/**
 * @author winson
 * @date 2021/9/27
 **/
public class PropertiesBeanDefinitionDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(beanFactory);
        String path = "user.properties";
        ClassPathResource classPathResource = new ClassPathResource(path);
        reader.loadBeanDefinitions(path);
//        Arrays.stream(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);
//        System.out.println(beanFactory.getBeanDefinition("superUser"));
        System.out.println(beanFactory.getBean(User.class));

    }

}
