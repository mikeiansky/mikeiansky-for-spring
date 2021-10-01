package com.winson.spring.bean.lifecycle;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

/**
 * @author winson
 * @date 2021/10/1
 **/
public class BeanFactoryAnnotationBeanCycleDependencyDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        beanFactory.setAllowEagerClassLoading(false);
        AutowiredAnnotationBeanPostProcessor processor = new AutowiredAnnotationBeanPostProcessor();
        processor.setBeanFactory(beanFactory);
        beanFactory.addBeanPostProcessor(processor);
//        beanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());

        BeanDefinition oneBeanDefinition = new GenericBeanDefinition();
        oneBeanDefinition.setBeanClassName(ActionOne.class.getName());
        oneBeanDefinition.setAutowireCandidate(true);
        oneBeanDefinition.setLazyInit(true);
//        oneBeanDefinition.getPropertyValues().add("two");
//        oneBeanDefinition.setDependsOn("two2");

        BeanDefinition twoBeanDefinition = new GenericBeanDefinition();
        twoBeanDefinition.setBeanClassName(ActionTwo.class.getName());
        twoBeanDefinition.setLazyInit(true);

        beanFactory.registerBeanDefinition("one", oneBeanDefinition);
        beanFactory.registerBeanDefinition("two", twoBeanDefinition);
        ActionOne one = beanFactory.getBean(ActionOne.class);
//        ActionTwo two = beanFactory.getBean(ActionTwo.class);
        System.out.println("====== one ======");
        System.out.println("one : " + one);
        System.out.println("one.getTwo() : " + one.getTwo());
//        System.out.println("====== two ======");
//        System.out.println("two : " + two);
//        System.out.println("two.getOne() : " + two.getOne());

    }

}
