package io.github.mikeiansky.spring.v6.overview.factory.dependency.injection;

import cn.hutool.core.codec.Rot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.annotation.Lazy;

/**
 * @author mike ian
 * @date 2025/4/30
 * @desc 也就是在一个bean是通过构造函数进行参数注入的时候， 这个时候这个bean还没有创建
 * ，但是它用于依赖注入的bean又依赖了这个为创建的bean，则会出现循环引用问题，这个时候需要
 * 通过给BeanFactory配置能够解析Lazy bean的resolver来进行懒加载
 **/
public class MoreThanTwoCircleReferenceDemo {

    public static class One {

        private Two two;

        public One(Two two) {
            this.two = two;
        }

    }

    public static class Two {

//        @Lazy
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
        // 解决循环引用的关键节点
        beanFactory.setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());

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
        System.out.println("three.one : " + three.one);
        System.out.println("three.one : " + three.one);

    }

}
