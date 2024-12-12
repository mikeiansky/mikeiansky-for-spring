package com.winson.spring.overview.bean;

import com.winson.spring.overview.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author winson
 * @date 2021/9/23
 **/
public class BeansInjectionDemo {



    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/winson-spring-overview.xml");
        UserRepository userRepository = context.getBean(UserRepository.class);
        System.out.println(userRepository);

        System.out.println("object factory =====> 1 ");
        System.out.println(userRepository.getObjectFactory().getObject());
        System.out.println(userRepository.getObjectFactory().getObject());

        System.out.println("object factory =====> 2 ");
        System.out.println(userRepository.getObjectFactory().getObject() == context);

        System.out.println("environment : " + context.getBean(Environment.class));

    }

}
