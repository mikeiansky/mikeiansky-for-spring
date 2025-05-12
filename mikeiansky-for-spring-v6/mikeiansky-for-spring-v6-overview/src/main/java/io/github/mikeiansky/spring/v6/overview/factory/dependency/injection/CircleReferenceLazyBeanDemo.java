package io.github.mikeiansky.spring.v6.overview.factory.dependency.injection;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.annotation.Lazy;

/**
 * @author mike ian
 * @date 2025/4/30
 * @desc 这里是一个死循环的互相依赖，可能无法解决
 **/
public class CircleReferenceLazyBeanDemo {

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
        // 如果不加这个会报错
//        beanFactory.setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());

        AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        autowiredAnnotationBeanPostProcessor.setBeanFactory(beanFactory);
        beanFactory.addBeanPostProcessor(autowiredAnnotationBeanPostProcessor);

        RootBeanDefinition oneBean = new RootBeanDefinition(One.class);
        oneBean.setLazyInit(true);
        beanFactory.registerBeanDefinition("one", oneBean);

        RootBeanDefinition twoBean = new RootBeanDefinition(Two.class);
        twoBean.setLazyInit(true);
        beanFactory.registerBeanDefinition("two", twoBean);


        One one = beanFactory.getBean(One.class);
        Two two = beanFactory.getBean(Two.class);
        System.out.println("one : " + one);
        System.out.println("one.two : " + one.two);
        System.out.println("two : " + two);
        System.out.println("two.one : " + two.one);

    }

}
