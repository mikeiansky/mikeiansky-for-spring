package io.github.mikeiansky.spring.v6.overview.container;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author mike ian
 * @date 2024/12/5
 * @desc
 **/
public class AnnotationBeanFactoryDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        factory.createBean(AnnotationContextDemo.class);

        String beanName = "io.github.mikeiansky.spring.v6.overview.AnnotationContextDemo";
        AnnotatedGenericBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(AnnotationContextDemo.class);
        factory.registerBeanDefinition(beanName, beanDefinition);

        AnnotationContextDemo demo = factory.getBean(AnnotationContextDemo.class);
        System.out.println(demo);
    }

}
