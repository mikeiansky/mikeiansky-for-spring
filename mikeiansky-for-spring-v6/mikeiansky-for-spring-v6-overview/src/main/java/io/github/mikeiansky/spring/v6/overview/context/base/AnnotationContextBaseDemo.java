package io.github.mikeiansky.spring.v6.overview.context.base;

import io.github.mikeiansky.spring.v6.overview.context.processor.SimpleBeanFactoryPostProcessor;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.core.PriorityOrdered;

/**
 * @author mike ian
 * @date 2024/12/5
 * @desc
 **/
public class AnnotationContextBaseDemo {

    public static class BeanDefinitionRegistryImplOne implements PriorityOrdered, BeanDefinitionRegistryPostProcessor {
        @Override
        public int getOrder() {
            return 0;
        }

        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        }
    }

    public static class BeanDefinitionRegistryImplSecond implements PriorityOrdered, BeanDefinitionRegistryPostProcessor {
        @Override
        public int getOrder() {
            return 0;
        }

        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        }
    }

    public static class One {

    }

    @Data
    public static class Two {
        @Autowired
        private One one;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanDefinitionRegistryImplOne.class);
        context.register(BeanDefinitionRegistryImplSecond.class);
        context.register(One.class);
        context.register(Two.class);
        context.refresh();

        One oneBean = context.getBean(One.class);
        System.out.println(oneBean);
        Two twoBean = context.getBean(Two.class);
        System.out.println(twoBean);

    }

}
