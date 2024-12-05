package com.winson.spring.dependency.injection.demo;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author winson
 * @date 2021/9/25
 **/
//@Configuration
public class AnnotationDependencyMethodInjectDemo {

    private UserHolder userHolder1;

    private UserHolder userHolder2;

    @Bean
    public UserHolder userHolder3(User user) {
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }

    @Autowired
    public void userHolder1(UserHolder userHolder) {
        this.userHolder1 = userHolder;
    }

    @Resource
    public void userHolder2(UserHolder userHolder) {
        this.userHolder2 = userHolder;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationDependencyMethodInjectDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String xmlClassPath = "classpath:/winson-spring-overview.xml";
        reader.loadBeanDefinitions(xmlClassPath);

        context.refresh();

//        System.out.println(context.getBeansOfType(UserHolder.class));
        UserHolder userHolder = context.getBean(UserHolder.class);

        AnnotationDependencyMethodInjectDemo demo = context.getBean(AnnotationDependencyMethodInjectDemo.class);
        System.out.println(demo.userHolder1);
        System.out.println(demo.userHolder2);
        System.out.println(userHolder);
        System.out.println(demo.userHolder1 == demo.userHolder2);
        System.out.println(demo.userHolder2 == userHolder);

        context.close();

    }


}
