package com.winson.spring.bean.demo;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author winson
 * @date 2021/9/24
 **/
public class BeanDefinitionDemo {

    public static void main(String[] args) {

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        beanDefinitionBuilder.addPropertyValue("name", "winson");
        beanDefinitionBuilder.addPropertyValue("age", 12);

        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println(beanDefinition);

        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mpv = new MutablePropertyValues();
        mpv.add("age", 32);
        mpv.add("name", "wenxiang");
        System.out.println(genericBeanDefinition);

//        DefaultBeanNameGenerator

    }


}
