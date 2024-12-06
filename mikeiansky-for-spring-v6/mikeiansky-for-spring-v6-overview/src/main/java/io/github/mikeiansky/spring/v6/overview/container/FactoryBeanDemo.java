package io.github.mikeiansky.spring.v6.overview.container;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author mike ian
 * @date 2024/12/6
 * @desc
 **/
@Configuration
public class FactoryBeanDemo {

    public static void main(String[] args) {
        RootBeanDefinition rootBeanDefinition  = new RootBeanDefinition(FactoryBean.class);

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition(null, null);

    }

}
