package io.github.mikeiansky.spring.v6.overview.container;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;

/**
 * @author mike ian
 * @date 2024/12/6
 * @desc
 **/
public class BeanFactoryTypeDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        String beanName = "beanFactoryTypeDemo";
        factory.registerBeanDefinition(beanName, new RootBeanDefinition(BeanFactoryTypeDemo.class));
        boolean typeMatchClazz = factory.isTypeMatch(beanName, BeanFactoryTypeDemo.class);
        boolean typeMatchRawType = factory.isTypeMatch(beanName, ResolvableType.forRawClass(BeanFactoryTypeDemo.class));
        boolean typeMatchOther = factory.isTypeMatch(beanName, ResolvableType.forRawClass(RootBeanDefinition.class));
        System.out.println(typeMatchClazz);
        System.out.println(typeMatchRawType);
        System.out.println(typeMatchOther);
    }

}
