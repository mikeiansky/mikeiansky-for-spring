package io.github.mikeiansky.spring.v6.overview.container;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author mike ian
 * @date 2024/12/5
 * @desc
 **/
public class AnnotationBeanFactoryDemo {

    private String tag;

    public void setTag(String tag) {
        this.tag = tag;
    }

    public static class Other {

    }

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

//        AnnotatedGenericBeanDefinition otherBeanDefinition = new AnnotatedGenericBeanDefinition(Other.class);
//        factory.registerBeanDefinition(Other.class.getName(), otherBeanDefinition);

        AnnotatedGenericBeanDefinition fatherBeanDefinition = new AnnotatedGenericBeanDefinition(AnnotationBeanFactoryDemo.class);
//        fatherBeanDefinition.setDependsOn(Other.class.getName());
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue("tag", "demo");
        fatherBeanDefinition.setPropertyValues(mutablePropertyValues);
//        fatherBeanDefinition.setDependsOn(Other.class.getName());
        factory.registerBeanDefinition(AnnotationBeanFactoryDemo.class.getName(), fatherBeanDefinition);

        AnnotationBeanFactoryDemo father = factory.getBean(AnnotationBeanFactoryDemo.class);
        System.out.println(father);
        System.out.println(father.tag);

//        factory.destroyBean(father);
    }

}
