package io.github.mikeiansky.spring.v6.overview.factory;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author mike ian
 * @date 2024/12/5
 * @desc
 **/
public class AnnotatedBeanFactoryBaseDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        AnnotatedGenericBeanDefinition fatherBeanDefinition = new AnnotatedGenericBeanDefinition(AnnotatedBeanFactoryBaseDemo.class);
        factory.registerBeanDefinition(AnnotatedBeanFactoryBaseDemo.class.getName(), fatherBeanDefinition);
        AnnotatedBeanFactoryBaseDemo father = factory.getBean(AnnotatedBeanFactoryBaseDemo.class);
        System.out.println(father);
    }

}
