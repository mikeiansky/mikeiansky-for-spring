package com.winson.spring.overview.bean;

import com.winson.spring.overview.annotation.Super;
import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author winson
 * @date 2021/9/23
 **/
public class BeansLookupDemo {

    public static void main(String[] args) {
        BeanFactory context = new ClassPathXmlApplicationContext("classpath:/winson-spring-overview.xml");
        lookupByType(context);
        lookupByName(context);
        lookupByLazy(context);
        lookupByAnnotation(context);
    }

    private static void lookupByAnnotation(BeanFactory context) {
        System.out.println("lookupByAnnotation === ");

        ListableBeanFactory factory = (ListableBeanFactory) context;
        Map<String,Object> beanMap = factory.getBeansWithAnnotation(Super.class);
        System.out.println(beanMap);
    }

    private static void lookupByLazy(BeanFactory context) {

        System.out.println("lookupByLazy === ");
        ObjectFactory user = (ObjectFactory) context.getBean("objectFactory");
        System.out.println(user.getObject());

    }

    private static void lookupByName(BeanFactory context) {
        System.out.println("lookupByName === ");
        ListableBeanFactory factory = (ListableBeanFactory) context;
        User user = (User) context.getBean("user");
        System.out.println(user);
    }

    public static void lookupByType(BeanFactory context){
        System.out.println("lookupByType === ");
        ListableBeanFactory factory = (ListableBeanFactory) context;
        Map<String,User> beans = factory.getBeansOfType(User.class);
        System.out.println(beans);
        System.out.println("main user: " + context.getBean(User.class));
    }

}
