package com.winson.study.spring.beans.definition;

import com.winson.study.spring.beans.factory.DefaultUserFactory;
import com.winson.study.spring.beans.factory.UserFactory;
import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author winson
 * @date 2021/6/19
 **/
public class SpecialBeanInitiationDemo {

    public static void main(String[] args) throws Exception {
        ApplicationContext beanFactory  = new ClassPathXmlApplicationContext("META-INF/special-bean-initiation-context.xml");

        AutowireCapableBeanFactory autowireCapableBeanFactory = beanFactory.getAutowireCapableBeanFactory();

        ServiceLoader<UserFactory> serviceLoader = (ServiceLoader<UserFactory>) beanFactory.getBean("userFactoryServiceLoader");
        System.out.println(serviceLoader);
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().generateUser());
        }
//        loadByServiceLoader();

        UserFactory userFactory = autowireCapableBeanFactory.createBean(DefaultUserFactory.class);
        userFactory.generateUser();

    }

    private static void loadByServiceLoader() {
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().generateUser());
        }
    }


}
