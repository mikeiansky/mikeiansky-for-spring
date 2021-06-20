package com.winson.study.spring.dependency.injection;

import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author winson
 * @date 2021/6/20
 **/
public class AnnotationDependencyInjectionSetterDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String resource = "classpath:/META-INF/study-spring-ioc-dependency-lookup.xml";
        reader.loadBeanDefinitions(resource);
        applicationContext.register(AnnotationDependencyInjectionSetterDemo.class);

        applicationContext.refresh();

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);

        applicationContext.close();

    }

    @Bean
    public UserHolder userHolder(User user){
        return new UserHolder(user);
    }

}
