package com.winson.spring.bean.demo;

import com.winson.spring.bean.factory.UserFactory;
import com.winson.spring.bean.factory.UserFactoryBean;
import com.winson.spring.overview.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2021/9/24
 **/
public class BeanInstantiationDemo {

    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/bean-instantiation-context.xml");
        UserFactory userFactory = context.getBean(UserFactory.class);
        System.out.println(userFactory);

        System.out.println("factory user : "+context.getBean("factoryUser"));
        UserFactoryBean userFactoryBean = context.getBean(UserFactoryBean.class);
        User userFactoryBean1 = userFactoryBean.getObject();
        User userFactoryBean2 = userFactoryBean.getObject();
        System.out.println("userFactoryBean1 : " + userFactoryBean1);
        System.out.println("userFactoryBean1 : " + userFactoryBean2);
        System.out.println("userFactoryBean1 == userFactoryBean2 : " + (userFactoryBean1 == userFactoryBean2));
        context.close();
        System.out.println("close....");
    }

}
