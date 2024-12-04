package com.winson.spring.dependency.injection.demo;

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
 **/
@Configuration
public class AutowireSelfInjectionDemo {

    // 引用其自身1
    @Autowired
//    @Qualifier("autowireSelfInjectionDemo")
    private AutowireSelfInjectionDemo self1;

    // 引用其自身2
    @Autowired
    @Qualifier("autowireSelfInjectionDemo")
    private AutowireSelfInjectionDemo self2;


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AutowireSelfInjectionDemo.class);

        context.refresh();
        AutowireSelfInjectionDemo demo = context.getBean(AutowireSelfInjectionDemo.class);

        System.out.println("demo : " + demo);
        System.out.println("demo.self1 : " + demo.self1);
        System.out.println("demo.self2 : " + demo.self2);


        context.close();

    }

}
