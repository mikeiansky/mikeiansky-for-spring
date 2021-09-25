package com.winson.spring.dependency.injection.demo;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/9/25
 **/
public class LazyDependencyInjectionDemo {

    @Autowired
    private ObjectProvider<User> userObjectProvider;

    @Autowired
    private ObjectFactory<User> userObjectFactory;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(LazyDependencyInjectionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String xmlClassPath = "classpath:/winson-spring-overview.xml";
        reader.loadBeanDefinitions(xmlClassPath);

        context.refresh();

        LazyDependencyInjectionDemo demo = context.getBean(LazyDependencyInjectionDemo.class);
        User user1 = demo.userObjectProvider.getObject();
        User user2 = demo.userObjectProvider.getObject();
        User user3 = demo.userObjectFactory.getObject();
        User user4 = demo.userObjectFactory.getObject();
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);
        System.out.println(user1 == user2);
        System.out.println(user3 == user4);
        System.out.println(user2 == user3);
        System.out.println("============");
        demo.userObjectProvider.stream().forEach(System.out::println);

        context.close();

    }

}
