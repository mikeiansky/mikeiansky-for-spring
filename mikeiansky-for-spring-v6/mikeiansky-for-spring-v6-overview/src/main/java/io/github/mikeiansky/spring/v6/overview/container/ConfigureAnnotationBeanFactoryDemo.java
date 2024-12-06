package io.github.mikeiansky.spring.v6.overview.container;

import io.github.mikeiansky.spring.v6.overview.domain.User;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mike ian
 * @date 2024/12/6
 * @desc
 **/
@Configuration
public class ConfigureAnnotationBeanFactoryDemo {

    @Bean
    public User createUser(){
        return new User();
    }

    public static void main(String[] args) {
        AnnotatedBeanDefinition annotatedBeanDefinition = new AnnotatedGenericBeanDefinition(ConfigureAnnotationBeanFactoryDemo.class);

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition(ConfigureAnnotationBeanFactoryDemo.class.getName(), annotatedBeanDefinition);

        ConfigureAnnotationBeanFactoryDemo demo = factory.getBean(ConfigureAnnotationBeanFactoryDemo.class);
        System.out.println(demo);

        User user = factory.getBean(User.class);
        System.out.println(user);

    }

}
