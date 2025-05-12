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
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();


        SingletonConflictDefinitionDemo demo = new SingletonConflictDefinitionDemo();
        factory.registerSingleton("demo1", demo);

        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(SingletonConflictDefinitionDemo.class);
//        rootBeanDefinition.setPrimary(true);
        factory.registerBeanDefinition("demo2", rootBeanDefinition);

        SingletonConflictDefinitionDemo bean = factory.getBean(SingletonConflictDefinitionDemo.class);
        System.out.println("bean is : " + bean);

    }

}
