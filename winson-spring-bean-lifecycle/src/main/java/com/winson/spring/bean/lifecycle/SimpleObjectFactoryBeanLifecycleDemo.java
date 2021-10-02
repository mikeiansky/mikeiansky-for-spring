package com.winson.spring.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class SimpleObjectFactoryBeanLifecycleDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(TempObjectFactory.class);

        beanFactory.registerBeanDefinition("tempObjectFactory", beanDefinition);

        TempObjectFactory tempObjectFactory = beanFactory.getBean(TempObjectFactory.class);
        System.out.println(tempObjectFactory);
        System.out.println(tempObjectFactory.getObject());
//        System.out.println(beanFactory.getBean(Temp.class));
    }

}
