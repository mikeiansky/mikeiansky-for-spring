package io.github.mikeiansky.spring.v6.overview.factory.bean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author mike ian
 * @date 2025/5/1
 * @desc
 **/
public class RootBeanBeanDemo {

    public static class One {

    }

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(One.class);
        beanFactory.registerBeanDefinition("one", rootBeanDefinition);
        One one = beanFactory.getBean(One.class);
        System.out.println("one bean : " + one);
    }
}
