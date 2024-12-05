package com.winson.spring.bean.lifecycle;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author winson
 * @date 2021/10/1
 **/
public class FactoryBeanLifecycleDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(TempFactoryBean.class);
//        beanDefinition.setFactoryBeanName("haha");
        beanFactory.registerBeanDefinition("tempFactoryBean", beanDefinition);

        TempFactoryBean tempFactoryBean = beanFactory.getBean(TempFactoryBean.class);
        try {
            Temp temp = tempFactoryBean.getObject();
            System.out.println(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        GenericBeanDefinition tempBeanDefinition = new GenericBeanDefinition();
        tempBeanDefinition.setBeanClass(Temp.class);
        tempBeanDefinition.setPrimary(true);
        beanFactory.registerBeanDefinition("temp", tempBeanDefinition);

        try {
            Temp temp2 = tempFactoryBean.getObject();
            System.out.println(temp2);
        } catch (Exception e) {
            e.printStackTrace();
        }


//        try {
//            Temp temp = tempFactoryBean.getObject();
//            System.out.println(temp);
//        }catch (Exception e){
//            e.printStackTrace();
//        }


    }

}
