package com.winson.java.beans.demo;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditor;
import java.util.stream.Stream;

/**
 * @author winson
 * @date 2021/6/15
 **/
public class TestJavaBeansDemo {

    public static void main(String[] args) throws IntrospectionException {
        System.out.println("test java beans demo start ... ");

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    System.out.println(propertyDescriptor);
//                    System.out.println(propertyDescriptor.getName());
//                    System.out.println(propertyDescriptor.getDisplayName());

                });

        System.out.println("test java beans demo stop ... ");
    }

}
