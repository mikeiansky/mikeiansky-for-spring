package com.winson.spring.overview.container;

import com.winson.spring.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


/**
 * @author winson
 * @date 2021/9/23
 **/
public class AnnotationApplicationAsIocContainerDemo {

    @Bean
    public User user(){
        User user = new User();
        user.setName("annotation user");
        user.setAge(3);
        return user;
    }


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationApplicationAsIocContainerDemo.class);
        context.refresh();

        User user = context.getBean(User.class);
        System.out.println(user);

    }

}
