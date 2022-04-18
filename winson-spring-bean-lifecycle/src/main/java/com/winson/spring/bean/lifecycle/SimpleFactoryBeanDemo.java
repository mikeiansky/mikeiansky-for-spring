package com.winson.spring.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class SimpleFactoryBeanDemo {

    public static void main(String[] args) throws Exception {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(SimpleFactoryBean.class);

        beanFactory.registerBeanDefinition("simpleFactoryBean", beanDefinition);

        SimpleFactoryBean simpleFactoryBean = beanFactory.getBean(SimpleFactoryBean.class);
        System.out.println("simpleFactoryBean : "+simpleFactoryBean);
        System.out.println("simpleFactoryBean.getObject() : "+simpleFactoryBean.getObject());
        System.out.println("simpleFactoryBean.getObject() : "+simpleFactoryBean.getObject());
        Temp temp1 = beanFactory.getBean(Temp.class);
        System.out.println("temp1 : " + temp1);
        Temp temp2 = beanFactory.getBean(Temp.class);
        System.out.println("temp2 : " + temp2);
        System.out.println("getBean(simpleFactoryBean): "+beanFactory.getBean("simpleFactoryBean"));
        System.out.println("getBean(&simpleFactoryBean): "+beanFactory.getBean("&simpleFactoryBean"));

//        ActionOne one = beanFactory.getBean(ActionOne.class);
//        System.out.println("action one : " + one);



    }

}
