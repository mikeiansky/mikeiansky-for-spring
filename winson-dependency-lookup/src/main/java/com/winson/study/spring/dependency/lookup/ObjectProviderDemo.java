package com.winson.study.spring.dependency.lookup;

import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * @author winson
 * @date 2021/6/19
 **/
public class ObjectProviderDemo {

    @Primary
    @Bean
    public String helloWorld() {
        return "hello,world";
    }

    @Bean
    public String message(){
        return "message";
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();

        lookupByObjectProvider(applicationContext);

        lookupByLazy(applicationContext);
        lookupByStreamOps(applicationContext);

        applicationContext.close();

    }

    private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        for (String item : objectProvider) {
            System.out.println(item);
        }
    }

    private static void lookupByLazy(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> objectFactory = applicationContext.getBeanProvider(User.class);
        System.out.println(objectFactory.getIfAvailable(User::createUser));
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectFactory = applicationContext.getBeanProvider(String.class);
        System.out.println(objectFactory.getObject());

    }

}
