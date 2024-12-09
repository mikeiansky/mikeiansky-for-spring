package io.github.mikeiansky.spring.v6.overview.factory;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author mike ian
 * @date 2024/12/9
 * @desc 属性设置
 **/
public class PropertiesSetBeanFactoryBaseDemo {

    private String tag;

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "PropertiesSetBeanFactoryBaseDemo{" +
                "tag='" + tag + '\'' +
                '}' + hashCode();
    }

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("tag", "simple");

        AnnotatedGenericBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(PropertiesSetBeanFactoryBaseDemo.class);
        beanDefinition.setPropertyValues(propertyValues);
        beanFactory.registerBeanDefinition(beanDefinition.getBeanClassName(), beanDefinition);

        PropertiesSetBeanFactoryBaseDemo bean = beanFactory.getBean(PropertiesSetBeanFactoryBaseDemo.class);
        System.out.println(bean);

    }

}
