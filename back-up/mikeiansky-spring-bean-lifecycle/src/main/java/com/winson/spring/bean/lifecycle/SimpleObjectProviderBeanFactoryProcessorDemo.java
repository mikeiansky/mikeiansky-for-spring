package com.winson.spring.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author winson
 * @date 2021/10/1
 **/
public class SimpleObjectProviderBeanFactoryProcessorDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.addBeanPostProcessor(new SmartInstantiationAwareBeanPostProcessor() {
            @Override
            public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
                System.out.println("predictBeanType beanName : " + beanName + " , beanClass : " + beanClass);
                return SmartInstantiationAwareBeanPostProcessor.super.predictBeanType(beanClass, beanName);
            }
        });
        beanFactory.addBeanPostProcessor(new MergedBeanDefinitionPostProcessor() {
            @Override
            public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
                System.out.println("postProcessMergedBeanDefinition beanName : " + beanName + " , beanType : " + beanType);
            }

        });
        beanFactory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
            @Override
            public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
                System.out.println("postProcessBeforeInstantiation beanName : " + beanName + " , beanClass : " + beanClass);
                return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
            }

            @Override
            public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
                System.out.println("postProcessAfterInstantiation beanName : " + beanName + " , bean : " + bean);
                return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
            }

            @Override
            public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
                System.out.println("postProcessProperties beanName : " + beanName + " , bean : " + bean + " , pvs : " + pvs);
                return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
            }

            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("postProcessBeforeInitialization beanName : " + beanName + " , bean : " + bean);
                return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("postProcessAfterInitialization beanName : " + beanName + " , bean : " + bean);
                return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
            }
        });

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Temp.class);

        beanFactory.registerBeanDefinition("Temp", beanDefinition);

        ObjectProvider<Temp> tempObjectProvider = beanFactory.getBeanProvider(Temp.class);
        System.out.println(tempObjectProvider);
        System.out.println("=============");
        System.out.println(tempObjectProvider.getIfAvailable());

//        GenericBeanDefinition beanDefinition2 = new GenericBeanDefinition();
//        beanDefinition2.setBeanClass(Temp.class);
//        beanDefinition2.setPrimary(true);
//        beanFactory.registerBeanDefinition("temp", beanDefinition2);
//        Temp temp2 = beanFactory.getBean(Temp.class);
//        System.out.println(temp2);
    }

}
