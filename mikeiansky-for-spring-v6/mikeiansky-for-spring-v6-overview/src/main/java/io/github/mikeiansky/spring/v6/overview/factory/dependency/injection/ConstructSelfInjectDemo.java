package io.github.mikeiansky.spring.v6.overview.factory.dependency.injection;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Lazy;

/**
 * @author mike ian
 * @date 2024/12/12
 * @desc
 **/
public class ConstructSelfInjectDemo {

    public static class One {

        @Lazy
        private One parent;

        public One( One parent) {
            this.parent = parent;
        }

        public One getParent() {
            return parent;
        }

    }

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("one", new RootBeanDefinition(One.class));

        AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
//        autowiredAnnotationBeanPostProcessor.setBeanFactory(factory);
        factory.addBeanPostProcessor(autowiredAnnotationBeanPostProcessor);

        One one = factory.getBean(One.class);
        System.out.println("one bean : " + one);
        System.out.println("one bean parent : " + one.getParent());

    }

}
