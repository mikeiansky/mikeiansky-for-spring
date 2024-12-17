package io.github.mikeiansky.spring.v6.overview.properties;

import lombok.Data;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.util.List;

/**
 * @author mike ian
 * @date 2024/12/17
 * @desc
 **/
public class TypeConvertDemo {

    @Data
    public static class Other {
        private String name;
        private Integer age;
    }

    @Data
    public static class One {

        private String tag;
        private List<String> friendList;
        private Other other;

    }

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addPropertyEditorRegistrar(registry -> registry.registerCustomEditor(Other.class, new PropertyEditorSupport() {
            @Override
            public void setValue(Object value) {
                super.setValue(value);
            }

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if (text != null) {
                    String[] filedList = text.split(",");
                    String name = filedList[0];
                    Integer age = Integer.parseInt(filedList[1]);
                    Other other = new Other();
                    other.setName(name);
                    other.setAge(age);
                    setValue(other);
                }
            }
        }));

        RootBeanDefinition beanDefinition = new RootBeanDefinition(One.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("tag", "one");
        propertyValues.addPropertyValue("friendList", "[one,two,three]");
        propertyValues.addPropertyValue("other", "ian,28");
//        propertyValues.addPropertyValue("other", "{name:oo, age:34}");
        beanDefinition.setPropertyValues(propertyValues);

        beanFactory.registerBeanDefinition("one", beanDefinition);

        One one = beanFactory.getBean(One.class);
        System.out.println(one);
        System.out.println(one.friendList.size());
//        System.out.println(one.other);

    }

}
