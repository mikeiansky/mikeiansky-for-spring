package com.winson.spring.dependency.injection.demo;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;

/**
 * @author winson
 * @date 2021/9/25
 **/
public class AnnotationDependencyResolutionInjectionDemo {

    @Autowired
    private UserHolder userHolder;

    @Resource
    private UserHolder userHolder2;

    @Bean
    public UserHolder userHolder(User user) {
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationDependencyResolutionInjectionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String xmlClassPath = "classpath:/winson-spring-overview.xml";
        reader.loadBeanDefinitions(xmlClassPath);

        context.refresh();


        UserHolder userHolder = context.getBean(UserHolder.class);
        System.out.println(userHolder);

        AnnotationDependencyResolutionInjectionDemo demo = context.getBean(AnnotationDependencyResolutionInjectionDemo.class);
        System.out.println(demo.userHolder);
        System.out.println(demo.userHolder2);
        System.out.println(demo.userHolder == demo.userHolder2);
        System.out.println(demo.userHolder == userHolder);



        context.close();

    }

}
