package com.winson.spring.dependency.injection.demo;

import com.winson.spring.dependency.injection.annotation.InjectedUser;
import com.winson.spring.dependency.injection.annotation.UserGroup;
import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.Collection;
import java.util.Optional;

/**
 * @author winson
 * @date 2021/9/25
 **/
public class QualifierDependencyInjectionDemo {

    @Autowired
    private User user;

    @Autowired
    @Qualifier("user")
    private User qualifierUser;

    @Autowired
    private Collection<User> collectionUsers;

    @Autowired
    @Qualifier
    private Collection<User> qualifierCollectionUsers;

    @Autowired
    @UserGroup
    private Collection<User> userGroupCollectionUsers;

    @Autowired
    private Optional<User> userOptional;

    @InjectedUser
    private User injectedUser;

    @Bean
    @Qualifier
    public static User user1() {
        return createUser(11);
    }

    @Bean
    @Qualifier
    public static User user2() {
        return createUser(12);
    }

    @Bean
    @UserGroup
    public static User user3() {
        return createUser(13);
    }

    @Bean
    @UserGroup
    public static User user4() {
        return createUser(14);
    }

    public static User createUser(int id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE - 3)
    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
        AutowiredAnnotationBeanPostProcessor processor = new AutowiredAnnotationBeanPostProcessor();
        processor.setAutowiredAnnotationType(InjectedUser.class);
        return processor;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(QualifierDependencyInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(context);
        String xmlClassPath = "classpath:/winson-spring-overview.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlClassPath);

        context.refresh();
//        System.out.println(context.getBeansOfType(User.class));
        QualifierDependencyInjectionDemo demo = context.getBean(QualifierDependencyInjectionDemo.class);

        System.out.println("demo.user : " + demo.user);
        System.out.println("demo.qualifierUser : " + demo.qualifierUser);
        System.out.println("demo.collectionUsers : " + demo.collectionUsers);
        System.out.println("demo.qualifierCollectionUsers : " + demo.qualifierCollectionUsers);
        System.out.println("demo.userGroupCollectionUsers : " + demo.userGroupCollectionUsers);
        System.out.println("demo.userOptional : " + demo.userOptional);
        System.out.println("demo.injectedUser : " + demo.injectedUser);

        context.close();

    }

}
