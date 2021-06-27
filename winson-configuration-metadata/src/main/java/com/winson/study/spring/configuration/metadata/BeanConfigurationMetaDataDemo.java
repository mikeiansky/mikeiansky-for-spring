package com.winson.study.spring.configuration.metadata;

import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ObjectUtils;

/**
 * @author winson
 * @date 2021/6/27
 **/
public class BeanConfigurationMetaDataDemo {

    public static void main(String[] args) {

        BeanDefinitionBuilder beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinition.addPropertyValue("name", "winson");
        beanDefinition.getBeanDefinition().setAttribute("name", "wenxiang");
        beanDefinition.getBeanDefinition().setSource("home");

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if(ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())){
                    BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
                    if(ObjectUtils.nullSafeEquals("home", bd.getSource())){
                        String name = (String) bd.getAttribute("name");
                        User user = (User) bean;
                        user.setName(name);
                    }
                }
                return null;
            }

        });

        beanFactory.registerBeanDefinition("user", beanDefinition.getBeanDefinition());


        System.out.println(beanFactory.getBean(User.class));

    }

}
