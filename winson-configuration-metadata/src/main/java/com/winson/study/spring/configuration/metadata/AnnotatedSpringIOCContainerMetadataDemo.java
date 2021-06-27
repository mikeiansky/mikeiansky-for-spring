package com.winson.study.spring.configuration.metadata;

import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import java.util.Map;

/**
 * @author winson
 * @date 2021/6/27
 **/
@ImportResource("classpath:/META-INF/study-spring-ioc-dependency-lookup.xml")
@Import(User.class)
public class AnnotatedSpringIOCContainerMetadataDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotatedSpringIOCContainerMetadataDemo.class);
        applicationContext.refresh();

        Map<String,User> beans = applicationContext.getBeansOfType(User.class);
        for (String beanName : beans.keySet()) {
            System.out.println("--> beanName : " + beanName + " , beanObject : " + beans.get(beanName));
        }

        applicationContext.close();

    }

}
