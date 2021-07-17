package com.winson.study.spring.annotation.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author winson
 * @date 2021/7/16
 **/
public class MyBeanPostProcess2 implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("process2 before init bean : " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("process2 after init bean : " + beanName);
        return bean;
    }
}
