package com.winson.study.spring.bean.scope;

import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Map;

/**
 * @author winson
 * @date 2021/6/22
 **/
public class ThreadLocalScopeDemo {

    public static User createUser() {
        User user = new User();
        user.setId(System.nanoTime());
        return user;
    }

    @Bean
    @Scope(ThreadLocalScope.SCOPE_NAME)
    public User threadLocalUser() {
        return createUser();
    }

    @Autowired
    private User threadLocalUser;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ThreadLocalScopeDemo.class);

        applicationContext.addBeanFactoryPostProcessor(new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                beanFactory.registerScope(ThreadLocalScope.SCOPE_NAME, new ThreadLocalScope());
            }
        });

        applicationContext.refresh();

        ThreadLocalScopeDemo threadLocalScopeDemo = applicationContext.getBean(ThreadLocalScopeDemo.class);
        System.out.println("threadLocalScopeDemo.threadLocalUser : " + threadLocalScopeDemo.threadLocalUser);


        for (int i = 0; i < 3; i++) {
            User threadLocalUser = applicationContext.getBean("threadLocalUser", User.class);
            System.out.println(Thread.currentThread().getName() + " -> threadLocalUser  ：" + threadLocalUser);
        }

        int size = 3;
        Thread[] threads = new Thread[size];
        for (int i = 0; i < size; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    User threadLocalUser = applicationContext.getBean("threadLocalUser", User.class);
                    System.out.println(Thread.currentThread().getName() + " -> threadLocalUser  ：" + threadLocalUser);
                }
            });
            threads[i].start();
        }
        try {
            for (int i = 0; i < size; i++) {
                threads[i].join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        applicationContext.close();

    }

}
