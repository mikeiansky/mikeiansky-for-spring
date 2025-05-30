package io.github.mikeiansky.spring.v6.overview.factory.dependency.injection;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author mike ian
 * @date 2024/12/11
 * @desc
 **/
public class EarlyInstantiationDemo {

    public static class One {

    }

    public static class Two {
        private final One one;

        public Two(One one) {
            this.one = one;
        }
    }

    public static void main(String[] args) {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("one", new AnnotatedGenericBeanDefinition(One.class));
        RootBeanDefinition twoBeanDefinition = new RootBeanDefinition(Two.class);

        // 选其中一种都可以
        factory.addBeanPostProcessor(new AutowiredAnnotationBeanPostProcessor());
//        twoBeanDefinition.setAttribute(RootBeanDefinition.PREFERRED_CONSTRUCTORS_ATTRIBUTE, Two.class.getConstructors());

        factory.registerBeanDefinition("two", twoBeanDefinition);

        // 这里报错
//        factory.preInstantiateSingletons();

        Two two = factory.getBean(Two.class);
        System.out.println("two :: " + two);
        System.out.println("two.one :: " + two.one);

    }

}
