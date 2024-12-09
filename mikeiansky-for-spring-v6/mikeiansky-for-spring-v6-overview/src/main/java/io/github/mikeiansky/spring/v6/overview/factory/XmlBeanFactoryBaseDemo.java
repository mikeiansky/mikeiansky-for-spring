package io.github.mikeiansky.spring.v6.overview.factory;

import io.github.mikeiansky.spring.v6.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author mike ian
 * @date 2023/8/17
 * @desc bean factory base xml bean definition
 **/
public class XmlBeanFactoryBaseDemo {

    public static void main(String[] args) {
        String resourcePath = "classpath:mikeiansky-spring-v6-overview.xml";
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resourcePath);
        User user = factory.getBean(User.class);
        System.out.println(user);
    }

}
