package com.winson.spring.dependency.injection.demo;

import com.winson.spring.dependency.injection.other.MyGeneric;
import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author winson
 * @date 2021/9/25
 * @desc 配置类的bean 都使用非 静态方法创建 Bean
 **/
@Configuration
public class QualifierDependencyInjectionDemoV2 {


    @Autowired
    @Qualifier("user2")
    private User user;

    @Bean
    @Primary
//    @Qualifier
//    @Qualifier("user1")
    public User user1() {
        return createUser(11);
    }

    // 这个产的BeanDefinition 不会带有 FactoryBean信息
    @Bean
//    @Qualifier
//    @Qualifier("user1")
    public User user2() {
        return createUser(12);
    }

    @Bean
//    @Primary
//    @Qualifier("user2")
    public FactoryBean<User> factoryUser(){
        return new FactoryBean<User>() {
            @Override
            public User getObject() throws Exception {
                return createUser(13);
            }

            @Override
            public Class<?> getObjectType() {
                return User.class;
            }
        };
    }

    public static User createUser(int id) {
        User user = new User();
        user.setId(id);
        return user;
    }


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(QualifierDependencyInjectionDemoV2.class);

        context.refresh();
        QualifierDependencyInjectionDemoV2 demo = context.getBean(QualifierDependencyInjectionDemoV2.class);

        System.out.println("demo : " + demo);
        System.out.println("demo.factoryUser : " + context.getBean("&factoryUser"));
        System.out.println("demo.user : " + demo.user);
        System.out.println("demo.user1 : " + context.getBean("user1"));
        System.out.println("demo.user2 : " + context.getBean("user2"));


        context.close();

    }

}
