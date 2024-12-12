package io.github.mikeiansky.spring.v6.overview.factory.dependency.injection;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author mike ian
 * @date 2024/12/12
 * @desc
 **/
public class ObjectFactoryInjectionDemo {

    public static class One {

    }

    public static class Two {

        @Autowired
        private ObjectFactory<One> oneObjectFactory;

    }

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        RootBeanDefinition oneBeanDef = new RootBeanDefinition(One.class);
        RootBeanDefinition twoBeanDef = new RootBeanDefinition(Two.class);
        beanFactory.registerBeanDefinition("one", oneBeanDef);
        beanFactory.registerBeanDefinition("two", twoBeanDef);

        AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        autowiredAnnotationBeanPostProcessor.setBeanFactory(beanFactory);
        beanFactory.addBeanPostProcessor(autowiredAnnotationBeanPostProcessor);

        One one = beanFactory.getBean(One.class);
        System.out.println("one : " + one);
        Two two = beanFactory.getBean(Two.class);
        System.out.println("two : " + two);
        System.out.println("two.oneObjectFactory : " + two.oneObjectFactory);
        System.out.println("two.oneObjectFactory.getObject()_1 : " + two.oneObjectFactory.getObject());
        System.out.println("two.oneObjectFactory.getObject()_2 : " + two.oneObjectFactory.getObject());

    }

}
