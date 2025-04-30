package io.github.mikeiansky.spring.v6.overview.factory.dependency.injection;

import cn.hutool.core.codec.Rot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Lazy;

/**
 * @author mike ian
 * @date 2025/4/30
 * @desc
 **/
public class MoreThanTwoCircleReferenceDemo {

    public static class One {

        private Two two;

        public One(Two two) {
            this.two = two;
        }

    }

    public static class Two {

        @Lazy
        @Autowired
        private Three three;

    }

    public static class Three {

        @Lazy
        @Autowired
        private One one;

    }

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        beanPostProcessor.setBeanFactory(beanFactory);
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        RootBeanDefinition oneBean = new RootBeanDefinition(One.class);
        beanFactory.registerBeanDefinition("one", oneBean);
        RootBeanDefinition twoBean = new RootBeanDefinition(Two.class);
        beanFactory.registerBeanDefinition("two", twoBean);
        RootBeanDefinition threeBean = new RootBeanDefinition(Three.class);
        beanFactory.registerBeanDefinition("three", threeBean);

        // 这里调换顺序会不会有问题
        One one = beanFactory.getBean(One.class);
        Two two = beanFactory.getBean(Two.class);
        Three three = beanFactory.getBean(Three.class);

        System.out.println("one : " + one);
        System.out.println("one.two : " + one.two);
        System.out.println("two : " + two);
        System.out.println("two.three : " + two.three);
        System.out.println("three : " + three);
        System.out.println("three.one : " + three);

    }

}
