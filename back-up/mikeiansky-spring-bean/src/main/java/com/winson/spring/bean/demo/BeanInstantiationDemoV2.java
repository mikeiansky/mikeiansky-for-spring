package com.winson.spring.bean.demo;

import com.winson.spring.bean.factory.DefaultUserFactory;
import com.winson.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.*;

/**
 * @author winson
 * @date 2021/9/24
 **/
@Import(BeanInstantiationDemoV2.Config.class)
public class BeanInstantiationDemoV2 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanInstantiationDemoV2.class);
        System.out.println("ready refresh ... ");
        context.refresh();
        System.out.println("complete refresh ... ");

        context.getBean(UserFactory.class);

        System.out.println("ready close ... ");
        context.close();
        System.out.println("complete close ... ");
    }

    @Configuration
    public static class Config {

        @Bean(initMethod = "initMethod" , destroyMethod = "destroyMethod")
        @Lazy(value = true)
        public DefaultUserFactory userFactory() {
            return new DefaultUserFactory();
        }

    }

}
