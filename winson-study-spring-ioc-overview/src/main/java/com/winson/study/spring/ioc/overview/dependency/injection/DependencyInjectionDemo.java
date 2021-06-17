package com.winson.study.spring.ioc.overview.dependency.injection;

import com.winson.study.spring.ioc.overview.domain.User;
import com.winson.study.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author winson
 * @date 2021/6/17
 **/
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        System.out.println("test dependency injection demo start ... ");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/study-spring-ioc-dependency-injection.xml");

        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        System.out.println("user repository users : " + userRepository.getUsers());
        System.out.println("user repository BeanFactory : " + userRepository.getBeanFactory());
        System.out.println("user repository ObjectFactory : " + userRepository.getObjectFactory());
        System.out.println("user repository ObjectFactory getObject : " + userRepository.getObjectFactory().getObject());
        System.out.println("environment application context : " + applicationContext);
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("spring core environment : " + environment);
        System.out.println(applicationContext == userRepository.getObjectFactory().getObject());


        System.out.println("test dependency injection demo end ... ");
    }

}
