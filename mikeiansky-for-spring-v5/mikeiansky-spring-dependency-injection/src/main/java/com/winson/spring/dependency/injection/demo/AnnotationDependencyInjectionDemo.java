package com.winson.spring.dependency.injection.demo;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @author winson
 * @date 2021/9/25
 **/
public class AnnotationDependencyInjectionDemo {

    @Autowired
    private User user;


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationDependencyInjectionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String xmlClassPath = "classpath:/winson-spring-overview.xml";
        reader.loadBeanDefinitions(xmlClassPath);

        // 参考 DefaultListableBeanFactory#resolveDependency
        // 关注二：AutowiredAnnotationBeanPostProcessor类
        // 关注三：AutowiredAnnotationBeanPostProcessor#postProcessMergedBeanDefinition
        // 关注三：AutowiredAnnotationBeanPostProcessor#postProcessProperties
        // 关注四：CommonAnnotationBeanPostProcessor

        context.refresh();

        AnnotationDependencyInjectionDemo demo = context.getBean(AnnotationDependencyInjectionDemo.class);
        System.out.println("demo.user : " + demo.user);


        context.close();

    }

}
