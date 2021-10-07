package com.winson.spring.context.lifecycle.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

/**
 * @author winson
 * @date 2021/10/7
 **/
public class SpringContextLifecycleDemoV1 {

    public static BeanDefinition createBeanDefinition(Class clazz) {
        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(clazz);
        return bd;
    }

    public static class RegisterProcess1 implements BeanDefinitionRegistryPostProcessor {

        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
            System.out.println("postProcessBeanDefinitionRegistry by RegisterProcess1");
            registry.registerBeanDefinition("registerProcess2", createBeanDefinition(RegisterProcess2.class));
            registry.registerBeanDefinition("registerProcess3", createBeanDefinition(RegisterProcess3.class));
            registry.registerBeanDefinition("p3", createBeanDefinition(BeanProcess3.class));
            registry.registerBeanDefinition("p4", createBeanDefinition(BeanProcess4.class));
        }

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            System.out.println("postProcessBeanFactory by RegisterProcess1");
        }

    }

    public static class RegisterProcess2 implements BeanDefinitionRegistryPostProcessor, Ordered {
        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
            System.out.println("postProcessBeanDefinitionRegistry by RegisterProcess2");
            registry.registerBeanDefinition("p2", createBeanDefinition(BeanProcess2.class));
        }

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            System.out.println("postProcessBeanFactory by RegisterProcess2");
        }

        @Override
        public int getOrder() {
            return 0;
        }
    }

    public static class RegisterProcess3 implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
            System.out.println("postProcessBeanDefinitionRegistry by RegisterProcess3");
            registry.registerBeanDefinition("p1", createBeanDefinition(BeanProcess1.class));
            // super bean process 实现了 Order的接口，会在其注册的为ProcessorBean 的时候进行实例化
            registry.registerBeanDefinition("super", createBeanDefinition(SuperBeanProcess.class));
        }

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            System.out.println("postProcessBeanFactory by RegisterProcess3");
        }

        @Override
        public int getOrder() {
            return 0;
        }
    }

    // SuperBeanProcess 实现了 PriorityOrdered 的接口，会在其注册的为 ProcessorBean 的时候进行实例化
    // 实现了PriorityOrdered接口的Processor 优先实例化与 实现Ordered 接口的 Processor
    public static class SuperBeanProcess implements BeanPostProcessor, PriorityOrdered {

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("postProcessBeforeInitialization by SuperBeanProcess");
            return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
        }

        @Override
        public int getOrder() {
            return 0;
        }
    }

    // SuperBeanProcess 实现了 Ordered 的接口，会在其注册的为 ProcesserBean 的时候进行实例化
    public static class BeanProcess1 implements BeanPostProcessor, Ordered {

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("postProcessBeforeInitialization by BeanProcess1");
            return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
        }

        @Override
        public int getOrder() {
            return 0;
        }
    }

    public static class BeanProcess2 implements BeanPostProcessor {

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("postProcessBeforeInitialization by BeanProcess2");
            return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
        }

//        @Override
//        public int getOrder() {
//            return 0;
//        }
    }

    public static class BeanProcess3 implements BeanPostProcessor {

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("postProcessBeforeInitialization by BeanProcess3");
            return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
        }

//        @Override
//        public int getOrder() {
//            return 0;
//        }
    }

    public static class BeanProcess4 implements BeanPostProcessor {

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("postProcessBeforeInitialization by BeanProcess4");
            return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
        }


    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Temp.class);
        context.addBeanFactoryPostProcessor(new RegisterProcess1());
//        ((ConfigurableListableBeanFactory)context.getBeanFactory()).addBeanPostProcessor(new BeanProcess3());
        context.refresh();

        context.close();

    }

}
