package com.winson.spring.bean.lifecycle;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class GetBeanBeforeRegisterDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();


        context.refresh();
        System.err.println("=========1 ");
        try {
            System.err.println(context.getBean(GetBeanBeforeRegisterDemo.class));
        }catch (Exception e){
            e.printStackTrace();
        }

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(GetBeanBeforeRegisterDemo.class);
        context.register(GetBeanBeforeRegisterDemo.class);

        System.err.println("=========2 ");
        try {
            System.err.println(context.getBean(GetBeanBeforeRegisterDemo.class));
        }catch (Exception e){
            e.printStackTrace();
        }

        context.close();

    }

}
