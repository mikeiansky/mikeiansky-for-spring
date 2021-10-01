package com.winson.spring.bean.lifecycle;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author winson
 * @date 2021/10/1
 **/
public class BeanFactoryProcessorDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Temp.class);

        beanFactory.registerBeanDefinition("temp", beanDefinition);

        Temp temp = beanFactory.getBean(Temp.class);
        System.out.println(temp);

//        GenericBeanDefinition beanDefinition2 = new GenericBeanDefinition();
//        beanDefinition2.setBeanClass(Temp.class);
//        beanDefinition2.setPrimary(true);
//        beanFactory.registerBeanDefinition("temp", beanDefinition2);
//        Temp temp2 = beanFactory.getBean(Temp.class);
//        System.out.println(temp2);
    }

}
