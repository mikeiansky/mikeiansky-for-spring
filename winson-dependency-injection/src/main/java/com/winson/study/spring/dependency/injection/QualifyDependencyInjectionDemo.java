package com.winson.study.spring.dependency.injection;

import com.winson.study.spring.dependency.injection.annotation.UserGroup;
import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

/**
 * @author winson
 * @date 2021/6/20
 **/
public class QualifyDependencyInjectionDemo {

    public static User createUser(int id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @Autowired
    public Collection<User> allUser;

    @Autowired
    @Qualifier
    public Collection<User> qualifierUser;

    @Autowired
    @UserGroup
    public Collection<User> userGroupUser;

    @Autowired
    @Qualifier("user")
    public User normalUser;

    @Autowired
    public User superUser;

    @Bean
    @Qualifier
    public User u6() {
        return createUser(6);
    }

    @Bean
    @Qualifier
    public User u7() {
        return createUser(7);
    }

    @Bean
    @UserGroup
    public User u8() {
        return createUser(8);
    }

    @Bean
    @UserGroup
    public User u9() {
        return createUser(9);
    }


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(QualifyDependencyInjectionDemo.class);

        String resource = "classpath:/META-INF/study-spring-ioc-dependency-lookup.xml";
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions(resource);

        applicationContext.refresh();

        QualifyDependencyInjectionDemo demo = applicationContext.getBean(QualifyDependencyInjectionDemo.class);
        System.out.println("normal user : " + demo.normalUser);
        System.out.println("super user : " + demo.superUser);
        System.out.println("all user : " + demo.allUser);
        System.out.println("qualifier user : " + demo.qualifierUser);
        System.out.println("user group user : " + demo.userGroupUser);


        applicationContext.close();

    }

}
