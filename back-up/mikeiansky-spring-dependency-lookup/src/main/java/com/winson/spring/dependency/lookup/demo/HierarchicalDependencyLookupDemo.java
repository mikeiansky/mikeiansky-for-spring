package com.winson.spring.dependency.lookup.demo;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author winson
 * @date 2021/9/25
 **/
public class HierarchicalDependencyLookupDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(HierarchicalDependencyLookupDemo.class);
        context.refresh();

        ConfigurableListableBeanFactory configurableListableBeanFactory = context.getBeanFactory();

        DefaultListableBeanFactory parentBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(parentBeanFactory);
        reader.loadBeanDefinitions("classpath:/winson-spring-overview.xml");

        configurableListableBeanFactory.setParentBeanFactory(parentBeanFactory);

        System.out.println("find user bean ==========");
        System.out.println(findOnlyLocal(configurableListableBeanFactory, "user"));
        System.out.println(findRecursionLocalBean(configurableListableBeanFactory, "user"));
        System.out.println(findOnlyLocal(parentBeanFactory, "user"));
        System.out.println(findRecursionLocalBean(parentBeanFactory, "user"));

        System.out.println("find hierarchicalUser bean ==========");
        System.out.println(findOnlyLocal(configurableListableBeanFactory, "hierarchicalUser"));
        System.out.println(findRecursionLocalBean(configurableListableBeanFactory, "hierarchicalUser"));
        System.out.println(findOnlyLocal(parentBeanFactory, "hierarchicalUser"));
        System.out.println(findRecursionLocalBean(parentBeanFactory, "hierarchicalUser"));

    }

    public static boolean findOnlyLocal(HierarchicalBeanFactory beanFactory, String beanName){
        return beanFactory.containsLocalBean(beanName);
    }

    public static boolean findRecursionLocalBean(HierarchicalBeanFactory hierarchicalBeanFactory, String beanName) {
        BeanFactory parentBeanFactory = hierarchicalBeanFactory.getParentBeanFactory();
        if (parentBeanFactory instanceof HierarchicalBeanFactory) {
            HierarchicalBeanFactory hbf = HierarchicalBeanFactory.class.cast(parentBeanFactory);
            if(findRecursionLocalBean(hbf, beanName)){
                return true;
            }
        }
        return hierarchicalBeanFactory.containsLocalBean(beanName);
    }

    @Bean
    public User hierarchicalUser() {
        User user = new User();
        user.setName("hierarchical user ==");
        user.setAge(37);
        return user;
    }

}
