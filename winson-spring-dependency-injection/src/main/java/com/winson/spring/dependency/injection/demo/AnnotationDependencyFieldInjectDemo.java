package com.winson.spring.dependency.injection.demo;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author winson
 * @date 2021/9/25
 **/
public class AnnotationDependencyFieldInjectDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationDependencyFieldInjectDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String xmlClassPath = "classpath:/winson-spring-overview.xml";
        reader.loadBeanDefinitions(xmlClassPath);

        context.refresh();


        UserHolder userHolder = context.getBean(UserHolder.class);
        System.out.println(userHolder);

        context.close();

    }

    @Bean
    public UserHolder userHolder(User user) {
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }

}
