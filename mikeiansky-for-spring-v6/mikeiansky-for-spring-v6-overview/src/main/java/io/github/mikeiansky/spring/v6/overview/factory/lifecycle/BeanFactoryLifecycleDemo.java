package io.github.mikeiansky.spring.v6.overview.factory.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author mike ian
 * @date 2024/12/10
 * @desc
 **/
public class BeanFactoryLifecycleDemo implements BeanFactoryAware, BeanNameAware, BeanClassLoaderAware, InitializingBean {

    public static void main(String[] args) {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(BeanFactoryLifecycleDemo.class);
        rootBeanDefinition.setInitMethodNames("selfInitMethod1", "selfInitMethod2", "selfInitMethod3");
        factory.registerBeanDefinition(BeanFactoryLifecycleDemo.class.getName(), rootBeanDefinition);

        factory.addBeanPostProcessor(new MergedBeanDefinitionPostProcessor() {
            @Override
            public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
                System.out.println("MergedBeanDefinitionPostProcessor ==> postProcessMergedBeanDefinition");
            }
        });
        factory.addBeanPostProcessor(new SmartInstantiationAwareBeanPostProcessor() {
            @Override
            public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
                System.out.println("SmartInstantiationAwareBeanPostProcessor ==> predictBeanType");
                return SmartInstantiationAwareBeanPostProcessor.super.predictBeanType(beanClass, beanName);
            }

            @Override
            public Class<?> determineBeanType(Class<?> beanClass, String beanName) throws BeansException {
                System.out.println("SmartInstantiationAwareBeanPostProcessor ==> determineBeanType");
                return SmartInstantiationAwareBeanPostProcessor.super.determineBeanType(beanClass, beanName);
            }

            @Override
            public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
                System.out.println("SmartInstantiationAwareBeanPostProcessor ==> determineCandidateConstructors");
                return SmartInstantiationAwareBeanPostProcessor.super.determineCandidateConstructors(beanClass, beanName);
            }

            @Override
            public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
                System.out.println("SmartInstantiationAwareBeanPostProcessor ==> getEarlyBeanReference");
                return SmartInstantiationAwareBeanPostProcessor.super.getEarlyBeanReference(bean, beanName);
            }

            @Override
            public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
                System.out.println("InstantiationAwareBeanPostProcessor ==> postProcessBeforeInstantiation");
                return SmartInstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
            }

            @Override
            public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
                System.out.println("InstantiationAwareBeanPostProcessor ==> postProcessAfterInstantiation");
                return SmartInstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
            }

            @Override
            public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
                System.out.println("InstantiationAwareBeanPostProcessor ==> postProcessProperties");
                return SmartInstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
            }

            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("BeanPostProcessor ==> postProcessBeforeInitialization");
                return SmartInstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("BeanPostProcessor ==> postProcessAfterInitialization");
                return SmartInstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
            }

        });

        BeanFactoryLifecycleDemo demo = factory.getBean(BeanFactoryLifecycleDemo.class);
        System.out.println("BeanFactoryLifecycleDemo ==> " + demo);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware ==> " + beanFactory);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("BeanClassLoaderAware ==> " + classLoader);

    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware ==> " + name);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet ==> " + this);
    }

    public void selfInitMethod1() {
        System.out.println("selfInitMethod1 ==> " + this);
    }

    public void selfInitMethod2() {
        System.out.println("selfInitMethod2 ==> " + this);
    }

    public void selfInitMethod3() {
        System.out.println("selfInitMethod3 ==> " + this);
    }

}
