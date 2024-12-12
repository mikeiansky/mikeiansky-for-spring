package io.github.mikeiansky.spring.v6.overview.factory.base;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author mike ian
 * @date 2024/12/12
 * @desc
 **/
public class HierarchyBeanFactoryDemo {

    public static class One {

    }

    public static void main(String[] args) {

        RootBeanDefinition parentOne = new RootBeanDefinition(One.class);
        RootBeanDefinition childOne = new RootBeanDefinition(One.class);
//        One parentOne = new One();
//        One childOne = new One();
//        System.out.println("parent one : " + parentOne);
//        System.out.println("child one : " + childOne);

        DefaultListableBeanFactory parentBeaFactory = new DefaultListableBeanFactory();
        parentBeaFactory.registerBeanDefinition("one", parentOne);

        DefaultListableBeanFactory beaFactory = new DefaultListableBeanFactory();
        beaFactory.setParentBeanFactory(parentBeaFactory);
//        beaFactory.registerBeanDefinition("one", childOne);

        One beanChildOne = beaFactory.getBean(One.class);
        One beanParentOne = parentBeaFactory.getBean(One.class);
//        One beanChildOne = beaFactory.getBean(One.class);
        System.out.println("beanParentOne : " + beanParentOne);
        System.out.println("beanChildOne : " + beanChildOne);


    }

}
