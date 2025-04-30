package io.github.mikeiansky.spring.v6.overview.factory.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author mike ian
 * @date 2025/4/30
 * @desc
 **/
public class LazyBeanDemo {

    public static class One {

    }

    public static class Two {

    }

    public static void main(String[] args) {
        DefaultListableBeanFactory  beanFactory = new DefaultListableBeanFactory();

        RootBeanDefinition oneBean  = new RootBeanDefinition(One.class);
        beanFactory.registerBeanDefinition("one", oneBean);

        RootBeanDefinition twoBean  = new RootBeanDefinition(Two.class);
        twoBean.setLazyInit(true);
        beanFactory.registerBeanDefinition("two", twoBean);

        One one = beanFactory.getBean(One.class);
        System.out.println(one);
        Two two = beanFactory.getBean(Two.class);
        System.out.println(two);

    }

}
