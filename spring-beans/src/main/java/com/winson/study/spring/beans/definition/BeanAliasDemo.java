package com.winson.study.spring.beans.definition;

import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2021/6/19
 **/
public class BeanAliasDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-dependency-lookup.xml");
        User winsonUser = (User) beanFactory.getBean("winson-user");
        User ciweiUser = (User) beanFactory.getBean("ciwei-user");
        System.out.println(winsonUser == ciweiUser);

    }

}
