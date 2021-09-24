package com.winson.spring.bean.demo;

import com.winson.spring.bean.factory.DefaultUserFactory;
import com.winson.spring.bean.factory.UserFactory;
import com.winson.spring.bean.factory.UserFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ServiceLoader;

/**
 * @author winson
 * @date 2021/9/24
 **/
public class SpecialBeanInstantiationDemo {

    public static void main(String[] args) throws Exception {

        System.out.println("1------------");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/special-bean-instantiation-context.xml");
        ServiceLoader<UserFactory> serviceLoader = (ServiceLoader<UserFactory>) context.getBean("userFactoryServiceLoader");
        System.out.println(serviceLoader);

        System.out.println("2------------");
        ServiceLoader<UserFactory> userFactoryBeans = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        for (Object userFactoryBean : userFactoryBeans) {
            System.out.println(userFactoryBean);
        }

        System.out.println("3------------");
        DefaultUserFactory userFactory = context.getAutowireCapableBeanFactory().createBean(DefaultUserFactory.class);
        System.out.println(userFactory);

    }

}
