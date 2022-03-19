package com.winson.spring.dependency.injection.demo;

import com.winson.spring.dependency.injection.annotation.InjectedUser;
import com.winson.spring.dependency.injection.annotation.UserGroup;
import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.Order;

import java.util.Collection;
import java.util.Optional;

/**
 * @author winson
 * @date 2021/9/25
 **/
@Configuration
public class QualifierDependencyInjectionDemoV2 {

    @Autowired
//    @Qualifier("user2")
    private User user;

    @Bean
    @Primary
//    @Qualifier("user2")
//    @Qualifier
    public static User user1() {
        return createUser(11);
    }

    @Bean
//    @Qualifier
    public static User user2() {
        return createUser(12);
    }

    public static User createUser(int id) {
        User user = new User();
        user.setId(id);
        return user;
    }


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(QualifierDependencyInjectionDemoV2.class);

//        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(context);
//        String xmlClassPath = "classpath:/winson-spring-overview.xml";
//        beanDefinitionReader.loadBeanDefinitions(xmlClassPath);

        context.refresh();
        QualifierDependencyInjectionDemoV2 demo = context.getBean(QualifierDependencyInjectionDemoV2.class);

        System.out.println("demo.user : " + demo.user);
        System.out.println("demo.user1 : " + context.getBean("user1"));
        System.out.println("demo.user2 : " + context.getBean("user2"));


        context.close();

    }

}
