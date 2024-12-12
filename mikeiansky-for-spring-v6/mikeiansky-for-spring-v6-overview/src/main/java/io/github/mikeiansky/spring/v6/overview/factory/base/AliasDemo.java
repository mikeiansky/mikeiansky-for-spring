package io.github.mikeiansky.spring.v6.overview.factory.base;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author mike ian
 * @date 2024/12/12
 * @desc
 **/
public class AliasDemo {

    public static class One {

    }

    public static void main(String[] args) {

        RootBeanDefinition beanDefinition = new RootBeanDefinition(One.class);

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("one", beanDefinition);
        beanFactory.registerAlias("one", "one-1");
        beanFactory.registerAlias("one", "one-2");
        beanFactory.registerAlias("one", "one-3");

        One one = beanFactory.getBean(One.class);
        System.out.println("one : " + one);

        One one1_1 = beanFactory.getBean("one-1", One.class);
        System.out.println("one1_1 : " + one1_1);

        One one1_2 = beanFactory.getBean("one-1", One.class);
        System.out.println("one1_2 : " + one1_2);

        System.out.println("alias : " + Arrays.stream(Optional.ofNullable(beanFactory.getAliases("one"))
                .orElse(new String[]{})).collect(Collectors.joining(",")));

    }

}
