package com.winson.spring.study.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @author winson
 * @date 2021/6/24
 **/
public class AnnotatedBeanDefinitionParsingDemo {


    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
        int beanCountBefore = beanFactory.getBeanDefinitionCount();
        reader.register(AnnotatedBeanDefinitionParsingDemo.class);
        int beanCountAfter = beanFactory.getBeanDefinitionCount();

        System.out.println("annotated bean definition reader 加载bean的数量：" + (beanCountAfter - beanCountBefore));
        System.out.println("annotated bean definition bean count : " + beanCountAfter);

        System.out.println(beanFactory.getBean("annotatedBeanDefinitionParsingDemo"));

    }

}
