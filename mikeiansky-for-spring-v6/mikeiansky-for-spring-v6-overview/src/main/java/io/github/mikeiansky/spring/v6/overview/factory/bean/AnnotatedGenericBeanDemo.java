package io.github.mikeiansky.spring.v6.overview.factory.bean;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author mike ian
 * @date 2025/5/1
 * @desc
 **/
public class AnnotatedGenericBeanDemo {

    public static class One {

    }

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedGenericBeanDefinition oneBeanDefinition = new AnnotatedGenericBeanDefinition(One.class);
        beanFactory.registerBeanDefinition("one", oneBeanDefinition);
        One one = beanFactory.getBean(One.class);
        System.out.println("one bean : " + one);
    }
}
