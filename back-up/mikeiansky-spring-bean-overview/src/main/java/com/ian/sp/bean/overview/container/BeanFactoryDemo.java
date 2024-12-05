package com.ian.sp.bean.overview.container;

import com.ian.sp.bean.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author mike ian
 * @date 2023/8/17
 * @desc
 **/
public class BeanFactoryDemo {

    public static void main(String[] args) {

        String resourcePath = "classpath:ian-sp-bean-overview.xml";
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resourcePath);

        User user = factory.getBean(User.class);

        System.out.println(user);
    }

}
