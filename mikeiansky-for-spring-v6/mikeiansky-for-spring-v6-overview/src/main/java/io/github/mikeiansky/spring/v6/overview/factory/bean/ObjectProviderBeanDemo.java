package io.github.mikeiansky.spring.v6.overview.factory.bean;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author mike ian
 * @date 2024/12/12
 * @desc
 **/
public class ObjectProviderBeanDemo {

    public static class One {

    }

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("one", new RootBeanDefinition(One.class));

//        One one = beanFactory.getBean(One.class);
//        System.out.println("one bean : " + one);

        ObjectProvider<One> oneProvider = beanFactory.getBeanProvider(One.class);
        System.out.println("oneProvider : " + oneProvider);
        System.out.println("oneProvider object_1 : " + oneProvider.getObject());
        System.out.println("oneProvider object_2 : " + oneProvider.getObject());

    }

}
