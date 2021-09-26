package com.winson.spring.dependency.source.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/9/26
 **/
public class ResolvableDependencySourceDemo {

    @Autowired
    private String message;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ResolvableDependencySourceDemo.class);

        context.addBeanFactoryPostProcessor(new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//                beanFactory.registerResolvableDependency(String.class, "haha-winson-1");
                beanFactory.registerResolvableDependency(String.class, "haha-winson-2");
            }
        });

        context.refresh();

        ResolvableDependencySourceDemo demo = context.getBean(ResolvableDependencySourceDemo.class);
        System.out.println(demo.message);

        context.close();
    }

}
