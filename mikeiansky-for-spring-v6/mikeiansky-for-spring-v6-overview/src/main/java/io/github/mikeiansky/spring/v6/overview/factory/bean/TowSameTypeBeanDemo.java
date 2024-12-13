package io.github.mikeiansky.spring.v6.overview.factory.bean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
public class TowSameTypeBeanDemo {

    public static class One {

    }

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        RootBeanDefinition oneBeanDefinition1 = new RootBeanDefinition(One.class);
        oneBeanDefinition1.setPrimary(false);
        beanFactory.registerBeanDefinition("one-1", oneBeanDefinition1);
        RootBeanDefinition oneBeanDefinition2 = new RootBeanDefinition(One.class);
        oneBeanDefinition2.setPrimary(true);
        beanFactory.registerBeanDefinition("one-2", oneBeanDefinition2);

        System.out.println("------- ");
        // error
        try {
            One one = beanFactory.getBean(One.class);
            System.out.println("one : " + one);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // success
        One one1 = beanFactory.getBean("one-1", One.class);
        System.out.println("one1 : " + one1);
        One one2 = beanFactory.getBean("one-2", One.class);
        System.out.println("one2 : " + one2);


    }

}
