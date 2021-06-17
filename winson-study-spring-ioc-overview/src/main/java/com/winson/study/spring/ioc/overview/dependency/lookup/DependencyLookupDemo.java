package com.winson.study.spring.ioc.overview.dependency.lookup;

import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.net.URL;

/**
 * @author winson
 * @date 2021/6/17
 **/
public class DependencyLookupDemo {

    public static void main(String[] args) {
        System.out.println("test spring ioc overview start ... ");
//        System.out.println("String class loader : " + String.class.getClassLoader());
//        System.out.println("File class loader : " + File.class.getClassLoader());
//        System.out.println("TestSpringIocOverview class loader : " + TestSpringIocOverview.class.getClassLoader());
//        System.out.println("TestSpringIocOverview class loader parent : " + TestSpringIocOverview.class.getClassLoader().getParent());
//        System.out.println("TestSpringIocOverview class loader resource '/' : " + TestSpringIocOverview.class.getClassLoader().getResource("/"));
//        System.out.println("TestSpringIocOverview class loader parent resource '/' : " + TestSpringIocOverview.class.getClassLoader().getParent().getResource("/"));

        DependencyLookupDemo springIocOverview = new DependencyLookupDemo();
        URL resourceURL = springIocOverview.getClass().getClassLoader().getResource("");
        String springContextFileName = "META-INF/study-spring-ioc-dependency-lookup.xml";
        String springContextFilePath = resourceURL.getPath() + springContextFileName;
        System.out.println(springContextFilePath);
        File file = new File(springContextFilePath);
        System.out.println(file.exists());

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/study-spring-ioc-dependency-lookup.xml");


        User user = (User) beanFactory.getBean("user");
        System.out.println("lookup bean by name : " + user);
        User u2 = beanFactory.getBean(User.class);
        System.out.println("lookup bean by type : " + u2);

        ObjectFactory<User> objectFactory = beanFactory.getBean(ObjectFactory.class);
        System.out.println("object factory bean : " + objectFactory.getObject());


        System.out.println("test spring ioc overview end ... ");
    }

}
