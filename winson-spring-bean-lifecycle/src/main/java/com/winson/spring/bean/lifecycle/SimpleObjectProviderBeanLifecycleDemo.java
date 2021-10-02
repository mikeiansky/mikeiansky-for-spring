package com.winson.spring.bean.lifecycle;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class SimpleObjectProviderBeanLifecycleDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Temp.class);

        beanFactory.registerBeanDefinition("temp", beanDefinition);

        ObjectProvider<Temp> tempObjectProvider1 = beanFactory.getBeanProvider(Temp.class);
        ObjectProvider<Temp> tempObjectProvider2 = beanFactory.getBeanProvider(Temp.class);
        ObjectFactory<Temp> tempObjectFactory3 = beanFactory.getBeanProvider(Temp.class);
        System.out.println(tempObjectProvider1);
        System.out.println(tempObjectProvider2);
        System.out.println(tempObjectFactory3);
        System.out.println("=========1");
        System.out.println(tempObjectProvider1.getIfAvailable());
        System.out.println(tempObjectProvider1.getIfAvailable());
        System.out.println("=========2");
        System.out.println(tempObjectProvider2.getIfAvailable());
        System.out.println(tempObjectProvider2.getIfAvailable());
        System.out.println("=========3");
        System.out.println(tempObjectFactory3.getObject());
        System.out.println(tempObjectFactory3.getObject());
    }

}
