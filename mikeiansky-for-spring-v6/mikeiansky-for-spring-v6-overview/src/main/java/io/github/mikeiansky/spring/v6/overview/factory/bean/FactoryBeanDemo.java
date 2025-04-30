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

//        OneFactoryBean oneFactoryBean = beanFactory.getBean(OneFactoryBean.class);
//        One one1 = beanFactory.getBean(One.class);
//        One one2 = beanFactory.getBean(One.class);
//        One one3 = beanFactory.getBean(One.class);
//        System.out.println("one1 bean :: " + one1);
//        System.out.println("one2 bean :: " + one2);
//        System.out.println("one3 bean :: " + one3);
//        System.out.println("oneFactoryBean :: " + oneFactoryBean);
//        System.out.println("oneFactoryBean.getObject()_1 " + oneFactoryBean.getObject());
//        System.out.println("oneFactoryBean.getObject()_2 " + oneFactoryBean.getObject());
//        System.out.println("oneFactoryBean.getObject()_3 " + oneFactoryBean.getObject());

        Object oneBean = beanFactory.getBean("one");
        System.out.println("oneBean : " + oneBean);
        Object defetchBean = beanFactory.getBean("&one");
        System.out.println("defetchBean : " + defetchBean);

    }

}
