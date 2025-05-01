package io.github.mikeiansky.spring.v6.overview.factory.bean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;

/**
 * @author mike ian
 * @date 2025/5/1
 * @desc
 **/
public class LazyBeanDemo {

    public static class One {

    }

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        beanFactory.setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());
        RootBeanDefinition beanDefinition = new RootBeanDefinition(One.class);
        beanDefinition.setLazyInit(true);
        beanFactory.registerBeanDefinition("one", beanDefinition);

        One one = beanFactory.getBean(One.class);
        System.out.println("one : " + one);
        System.out.println("one.class : " + one.getClass());
    }

}
