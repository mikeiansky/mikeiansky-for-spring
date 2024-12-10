package io.github.mikeiansky.spring.v6.overview.factory.base;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author mike ian
 * @date 2024/12/10
 * @desc
 **/
public class ConstructBeanBeanFactoryDemo {

    public ConstructBeanBeanFactoryDemo(String hello) {
        System.out.println("construct bean bean factory : " + hello);
    }

    public static void main(String[] args) {
        System.out.println(ConstructBeanBeanFactoryDemo.class.getName());

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        AnnotatedGenericBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(ConstructBeanBeanFactoryDemo.class);
        factory.registerBeanDefinition(ConstructBeanBeanFactoryDemo.class.getName(), beanDefinition);

        ConstructBeanBeanFactoryDemo demo = factory.getBean(ConstructBeanBeanFactoryDemo.class);
        System.out.println("demo :: " + demo);
    }

}
