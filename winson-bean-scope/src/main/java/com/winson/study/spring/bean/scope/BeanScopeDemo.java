package com.winson.study.spring.bean.scope;

import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Map;

/**
 * @author winson
 * @date 2021/6/22
 **/
public class BeanScopeDemo {

    public static User createUser() {
        User user = new User();
        user.setId(System.nanoTime());
        return user;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    private User singletonUser() {
        return createUser();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    private User prototypeUser() {
        return createUser();
    }

    @Autowired
    private User singletonUser;

    @Autowired
    private User prototypeUser;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser2;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser3;

    @Autowired
    private Map<String,User> users;


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanScopeDemo.class);
        applicationContext.refresh();

        BeanScopeDemo beanScopeDemo = applicationContext.getBean(BeanScopeDemo.class);

        for (int i = 0; i < 3; i++) {
            User singletonUser = applicationContext.getBean("singletonUser", User.class);
            User prototypeUser = applicationContext.getBean("prototypeUser", User.class);
            System.out.println("singleton user ：" + singletonUser);
            System.out.println("prototypeUser user ：" + prototypeUser);
        }

        System.out.println("beanScopeDemo.singletonUser:" + beanScopeDemo.singletonUser);
        System.out.println("beanScopeDemo.prototypeUser:" + beanScopeDemo.prototypeUser);
        System.out.println("beanScopeDemo.prototypeUser2:" + beanScopeDemo.prototypeUser2);
        System.out.println("beanScopeDemo.prototypeUser3:" + beanScopeDemo.prototypeUser3);
        System.out.println("beanScopeDemo.users:" + beanScopeDemo.users);


        applicationContext.close();

    }

}
