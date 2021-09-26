package com.winson.spring.dependency.source.demo;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

/**
 * @author winson
 * @date 2021/9/26
 **/
public class DependencyLookupSourceDemo {

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DependencyLookupSourceDemo.class);
        context.refresh();

        DependencyLookupSourceDemo demo = context.getBean(DependencyLookupSourceDemo.class);
        System.out.println("context : " + context);
        System.out.println("demo : " + demo);
        System.out.println("demo.beanFactory : " + demo.beanFactory);
        System.out.println("demo.resourceLoader : " + demo.resourceLoader);
        System.out.println("demo.applicationContext : " + demo.applicationContext);
        System.out.println("demo.applicationEventPublisher : " + demo.applicationEventPublisher);
//        System.out.println("getBean -> beanFactory : " + context.getBean(BeanFactory.class));

        ObjectProvider<BeanFactory> beanFactoryObjectProvider =  context.getBeanProvider(BeanFactory.class);
        System.out.println(beanFactoryObjectProvider.getIfAvailable());

        context.close();

    }

}
