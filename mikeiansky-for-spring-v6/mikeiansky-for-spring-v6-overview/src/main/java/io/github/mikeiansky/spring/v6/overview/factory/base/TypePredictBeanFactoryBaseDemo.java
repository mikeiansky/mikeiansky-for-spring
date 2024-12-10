package io.github.mikeiansky.spring.v6.overview.factory.base;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;

/**
 * @author mike ian
 * @date 2024/12/6
 * @desc 类型匹配识别
 **/
public class TypePredictBeanFactoryBaseDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        String beanName = "beanFactoryTypeDemo";
        factory.registerBeanDefinition(beanName, new RootBeanDefinition(TypePredictBeanFactoryBaseDemo.class));
        boolean typeMatchClazz = factory.isTypeMatch(beanName, TypePredictBeanFactoryBaseDemo.class);
        boolean typeMatchRawType = factory.isTypeMatch(beanName, ResolvableType.forRawClass(TypePredictBeanFactoryBaseDemo.class));
        boolean typeMatchOther = factory.isTypeMatch(beanName, ResolvableType.forRawClass(RootBeanDefinition.class));
        System.out.println(typeMatchClazz);
        System.out.println(typeMatchRawType);
        System.out.println(typeMatchOther);
    }

}
