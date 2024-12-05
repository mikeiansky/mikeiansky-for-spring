package com.winson.spring.bean.metadata;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class YamlBaseXmlDemo {

    @Value("${winson.name}")
    private String name;

    @Value("${winson.age}")
    private int age;

    public static void main(String[] args) {

        String path = "classpath:/META-INF/winson-yaml-xml.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{path}, false);

//        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
//        beanDefinition.setBeanClass(YamlBaseXmlDemo.class);
//        ((DefaultListableBeanFactory)context.getBeanFactory()).registerBeanDefinition("demo", beanDefinition);
//
//        YamlBaseXmlDemo demo = context.getBean(YamlBaseXmlDemo.class);
//        System.out.println(demo);
//        System.out.println(demo.name);
//        System.out.println(demo.age);

        System.out.println(context.getBean(YamlMapFactoryBean.class).getObject());

    }

}
