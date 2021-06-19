package com.winson.study.spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2021/6/19
 **/
public class HierarchyDependencyLookupDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(HierarchyDependencyLookupDemo.class);
        applicationContext.refresh();


        DefaultListableBeanFactory parentBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(parentBeanFactory);
        reader.loadBeanDefinitions("classpath:/META-INF/study-spring-ioc-dependency-lookup.xml");

        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        beanFactory.setParentBeanFactory(parentBeanFactory);

        displayLocalBean(beanFactory, "user");
        displayLocalBean((HierarchicalBeanFactory) beanFactory.getParentBeanFactory(), "user");

        System.out.println(displayBean(beanFactory, "user"));
        System.out.println(displayBean(parentBeanFactory, "user"));


        applicationContext.close();
    }

    public static boolean displayBean(HierarchicalBeanFactory beanFactory, String beanName){
        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
        if(parentBeanFactory instanceof HierarchicalBeanFactory){
            HierarchicalBeanFactory bf = HierarchicalBeanFactory.class.cast(parentBeanFactory);
            if(displayBean(bf, beanName)){
                return true;
            }
        }
        return beanFactory.containsLocalBean(beanName);
    }

    public static void displayLocalBean(HierarchicalBeanFactory beanFactory, String localBeanName) {
        System.out.println(String.format("BeanFactory %s, contains bean name %s : %s", beanFactory, localBeanName, beanFactory.containsLocalBean(localBeanName)));
    }

    public static boolean containsLocalBean(BeanFactory beanFactory, String localBeanName) {
        if (beanFactory instanceof HierarchicalBeanFactory) {
            HierarchicalBeanFactory hb = HierarchicalBeanFactory.class.cast(beanFactory);
            if (containsLocalBean(hb, localBeanName)) {
                return true;
            }
        }
        return beanFactory.containsBean(localBeanName);
    }

}
