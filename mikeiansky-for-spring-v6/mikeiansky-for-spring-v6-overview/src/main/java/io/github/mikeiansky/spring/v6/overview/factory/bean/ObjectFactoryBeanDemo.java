package io.github.mikeiansky.spring.v6.overview.factory.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author mike ian
 * @date 2024/12/12
 * @desc
 **/
public class ObjectFactoryBeanDemo {

    public static class One {

    }

    public static class OneObjectFactory implements ObjectFactory<One> {

        @Override
        public One getObject() throws BeansException {
            System.out.println("OneObjectFactory :: getObject");
            return new One();
        }

    }

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        RootBeanDefinition oneBeanDef = new RootBeanDefinition(OneObjectFactory.class);
        beanFactory.registerBeanDefinition("one", oneBeanDef);

        OneObjectFactory objectFactory = beanFactory.getBean(OneObjectFactory.class);
        System.out.println("objectFactory :: " + objectFactory);
        System.out.println("One :: " + objectFactory.getObject());
//        One oneBean = beanFactory.getBean(One.class);
//        System.out.println("oneBean :: " + oneBean);

    }

}
