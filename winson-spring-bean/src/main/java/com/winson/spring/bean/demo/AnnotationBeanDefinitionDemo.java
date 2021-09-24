package com.winson.spring.bean.demo;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author winson
 * @date 2021/9/24
 **/
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(AnnotationBeanDefinitionDemo.class);

        context.refresh();

        registerWithNoName(context);
        registerWithName(context, "from-main");

        System.out.println(context.getBeansOfType(User.class));


        context.close();

    }

    public static void registerWithNoName(BeanDefinitionRegistry beanDefinitionRegistry) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name", "winson-home-with-name")
                .addPropertyValue("age", 25);
        registerBean(beanDefinitionBuilder.getBeanDefinition(), beanDefinitionRegistry, null);

    }

    public static void registerWithName(BeanDefinitionRegistry beanDefinitionRegistry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name", "winson-home-no-name")
                .addPropertyValue("age", 33);
        registerBean(beanDefinitionBuilder.getBeanDefinition(), beanDefinitionRegistry, beanName);

    }

    public static void registerBean(AbstractBeanDefinition beanDefinition, BeanDefinitionRegistry registry, String beanName) {
        if(beanName != null){
            registry.registerBeanDefinition(beanName, beanDefinition);
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
        }
    }

    @Configuration
    public static class Config {

        @Bean
        public User user() {
            User user = new User();
            user.setName("zwx");
            user.setAge(20);
            return user;
        }

    }


}
