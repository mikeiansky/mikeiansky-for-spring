package com.winson.study.spring.beans.definition;

import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2021/6/19
 **/
public class BeanInitiationDemo {

    public static void main(String[] args) throws Exception {

        BeanFactory beanFactory  = new ClassPathXmlApplicationContext("META-INF/bean-initiation-context.xml");
        User userCreateByMethod = (User) beanFactory.getBean("user-static-method");
        User userCreateByBean = (User) beanFactory.getBean("user-create-by-bean");
        User userFactoryBean = (User) beanFactory.getBean("user-create-by-factory-bean");
        System.out.println(userCreateByMethod);
        System.out.println(userCreateByBean);
        System.out.println(userFactoryBean);
        System.out.println(userCreateByMethod == userCreateByBean);
        System.out.println(userCreateByMethod == userFactoryBean);

    }

}
