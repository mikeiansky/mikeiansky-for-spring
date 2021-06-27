package com.winson.spring.study.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

/**
 * @author winson
 * @date 2021/6/27
 **/
public class MyDestructionBeanPostProcessor implements DestructionAwareBeanPostProcessor {

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeDestruction ---> beanName : " + beanName + " , bean : " + bean);
    }

}
