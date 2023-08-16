package com.winson.spring.dependency.lookup.demo;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author winson
 * @date 2021/9/25
 **/
public class TypeSafeDependencyLookupDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TypeSafeDependencyLookupDemo.class);
        context.refresh();

        display("getBean", () -> {
            context.getBean(User.class);
        });

        display("objectFactory", ()->{
            ObjectFactory<User> userObjectFactory = context.getBeanProvider(User.class);
            userObjectFactory.getObject();
        });

        display("getBeansOfType",()->{
            context.getBeansOfType(User.class);
        });

        display("getBeanProvider", ()->{
            ObjectProvider<User> userObjectProvider = context.getBeanProvider(User.class);
            userObjectProvider.getIfAvailable();
        });

        display("getBeanProviderStream", ()->{
            ObjectProvider<User> userObjectProvider = context.getBeanProvider(User.class);
            userObjectProvider.stream().forEach(System.out::println);
        });

        context.close();

    }

    public static void display(String source, Runnable runnable) {
        System.err.println("========= " + source);
        try {
            runnable.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
