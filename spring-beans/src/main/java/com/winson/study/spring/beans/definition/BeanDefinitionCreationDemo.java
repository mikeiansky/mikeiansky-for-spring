package com.winson.study.spring.beans.definition;

import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author winson
 * @date 2021/6/19
 **/
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        System.out.println("bean definition creation demo start ... ");

        // 方式一，通过BeanDefinitionBuilder方式创建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name", "winson");
        beanDefinitionBuilder.addPropertyValue("age", 29);
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        // 方式二，通过AbstractBeanDefinition及其派生子类创建
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("name", "wenxiang")
                .add("age", 30);
        genericBeanDefinition.setPropertyValues(propertyValues);


        System.out.println("bean definition creation demo end ... ");
    }

}
