package io.github.mikeiansky.spring.v6.overview.factory.bean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author mike ian
 * @date 2024/12/10
 * @desc
 **/
public class SingletonConflictDefinitionDemo {

    public static void main(String[] args) {
        SingletonConflictDefinitionDemo demo = new SingletonConflictDefinitionDemo();
        System.out.println("demo1 is : " + demo);

        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(SingletonConflictDefinitionDemo.class);
//        rootBeanDefinition.setPrimary(true);
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("demo1", demo);
        factory.registerBeanDefinition("demo2", rootBeanDefinition);

        SingletonConflictDefinitionDemo bean = factory.getBean(SingletonConflictDefinitionDemo.class);
        System.out.println("bean is : " + bean);

    }

}
