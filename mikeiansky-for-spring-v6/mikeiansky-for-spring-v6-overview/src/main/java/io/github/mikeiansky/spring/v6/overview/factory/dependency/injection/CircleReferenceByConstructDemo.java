package io.github.mikeiansky.spring.v6.overview.factory.dependency.injection;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.annotation.Lazy;

public class CircleReferenceByConstructDemo {

    public static class One {

        private Two two;

        public One(Two two) {
            this.two = two;
        }

    }

    public static class Two {
        private One one;
        public Two(@Lazy One one) {
            this.one = one;
        }

    }



    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());
        AutowiredAnnotationBeanPostProcessor autowiredBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        autowiredBeanPostProcessor.setBeanFactory(beanFactory);
        beanFactory.addBeanPostProcessor(autowiredBeanPostProcessor);

        RootBeanDefinition oneBeanDefinition = new RootBeanDefinition(One.class);
        RootBeanDefinition twoBeanDefinition = new RootBeanDefinition(Two.class);

        beanFactory.registerBeanDefinition("one", twoBeanDefinition);
        beanFactory.registerBeanDefinition("two", oneBeanDefinition);

        One one = beanFactory.getBean(One.class);
        Two two = beanFactory.getBean(Two.class);
        System.out.println("one : " + one);
        System.out.println("one.two : " + one.two);
        System.out.println("two : " + two);
        System.out.println("two.one : " + two.one);
        System.out.println("two.one.getClass : " + two.one.getClass());

    }

}
