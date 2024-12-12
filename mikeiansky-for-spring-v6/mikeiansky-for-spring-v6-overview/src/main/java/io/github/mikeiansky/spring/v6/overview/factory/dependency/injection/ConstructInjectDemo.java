package io.github.mikeiansky.spring.v6.overview.factory.dependency.injection;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author mike ian
 * @date 2024/12/12
 * @desc
 **/
public class ConstructInjectDemo {

    public static class One {

    }

    public static class Two {

        private One one;

        public Two(One one) {
            this.one = one;
        }

//        public Two(){
//
//        }

    }

    public static void main(String[] args) {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("one", new RootBeanDefinition(One.class));
        factory.registerBeanDefinition("two", new RootBeanDefinition(Two.class));

        AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        factory.addBeanPostProcessor(autowiredAnnotationBeanPostProcessor);

        Two two = factory.getBean(Two.class);
        System.out.println("two : " + two);
        System.out.println("one of two : " + two.one);

    }

}
