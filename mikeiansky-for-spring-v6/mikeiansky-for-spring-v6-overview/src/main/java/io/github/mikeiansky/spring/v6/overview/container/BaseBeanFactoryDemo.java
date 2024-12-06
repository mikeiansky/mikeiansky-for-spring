package io.github.mikeiansky.spring.v6.overview.container;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author mike ian
 * @date 2024/12/5
 * @desc
 **/
public class BaseBeanFactoryDemo {

    private String tag;

    private Other otherField;

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setOtherField(Other otherField) {
        this.otherField = otherField;
    }

    public static class Other {

    }

    @Override
    public String toString() {
        return "AnnotationBeanFactoryDemo{" +
                "tag='" + tag + '\'' +
                ", otherField=" + otherField +
                '}';
    }

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        AnnotatedGenericBeanDefinition otherBeanDefinition = new AnnotatedGenericBeanDefinition(Other.class);
//        factory.registerBeanDefinition(Other.class.getName(), otherBeanDefinition);

        AnnotatedGenericBeanDefinition fatherBeanDefinition = new AnnotatedGenericBeanDefinition(BaseBeanFactoryDemo.class);
//        fatherBeanDefinition.setDependsOn(Other.class.getName());
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue("tag", "demo");
        mutablePropertyValues.addPropertyValue("otherField", otherBeanDefinition);
        fatherBeanDefinition.setPropertyValues(mutablePropertyValues);
//        fatherBeanDefinition.setDependsOn(Other.class.getName());
        factory.registerBeanDefinition(BaseBeanFactoryDemo.class.getName(), fatherBeanDefinition);

        BaseBeanFactoryDemo father = factory.getBean(BaseBeanFactoryDemo.class);
        System.out.println(father);
        System.out.println(father.tag);

//        factory.destroyBean(father);
    }

}
