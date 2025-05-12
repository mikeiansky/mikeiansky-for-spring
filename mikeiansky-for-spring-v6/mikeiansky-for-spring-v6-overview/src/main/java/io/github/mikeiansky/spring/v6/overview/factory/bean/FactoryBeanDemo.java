package io.github.mikeiansky.spring.v6.overview.factory.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author mike ian
 * @date 2024/12/12
 * @desc
 **/
public class FactoryBeanDemo {

    public static class One {

    }

    public static class OneFactoryBean implements FactoryBean<One> {

        @Override
        public One getObject() throws Exception {
            System.out.println("factory bean getObject");
            return new One();
        }

        @Override
        public Class<?> getObjectType() {
            System.out.println("factory bean getObjectType");
            return One.class;
        }

    }

    public static void main(String[] args) throws Exception {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("one", new RootBeanDefinition(OneFactoryBean.class));
        Object oneBean1 = beanFactory.getBean(One.class);
        System.out.println("oneBean1 : " + oneBean1);
        Object oneBean2 = beanFactory.getBean("one");
        System.out.println("oneBean2 : " + oneBean2);
        Object oneBean3 = beanFactory.getBean(One.class);
        System.out.println("oneBean3 : " + oneBean1);
        Object oneBean4 = beanFactory.getBean("one");
        System.out.println("oneBean4 : " + oneBean4);
        Object factoryBean = beanFactory.getBean(OneFactoryBean.class);
        System.out.println("factoryBean : " + factoryBean);
        Object deferenceBean = beanFactory.getBean("&one");
        System.out.println("deferenceBean : " + deferenceBean);

    }

}
