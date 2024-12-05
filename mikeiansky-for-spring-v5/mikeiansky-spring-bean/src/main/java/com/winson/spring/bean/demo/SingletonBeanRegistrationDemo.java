package com.winson.spring.bean.demo;

import com.winson.spring.overview.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2021/9/24
 **/
public class SingletonBeanRegistrationDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/bean-definitions-context.xml");

        System.out.println(context.getBeansOfType(User.class));

        User outUser = new User();
        outUser.setName("out user");
        outUser.setAge(47);
        System.out.println(outUser);

        context.getBeanFactory().registerSingleton("out-user", outUser);

        User outUserBean = (User) context.getBean("out-user");
        System.out.println(outUserBean);

        System.out.println(outUser == outUserBean);


    }

}
