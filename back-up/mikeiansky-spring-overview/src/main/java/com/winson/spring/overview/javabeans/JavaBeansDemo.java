package com.winson.spring.overview.javabeans;

import com.winson.spring.overview.domain.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @author winson
 * @date 2021/9/23
 **/
public class JavaBeansDemo {

    public static class MyPropertyEditorSupport extends PropertyEditorSupport{

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            super.setAsText(text);
            System.out.println("setAsText");
        }

        @Override
        public void setValue(Object value) {
            super.setValue(value);
            System.out.println("setValue");
        }

    }

    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(pd -> {
                    pd.setPropertyEditorClass(MyPropertyEditorSupport.class);
                    System.out.println(pd.getName());
//                    System.out.println(pd.getValue(pd.getName()));
                });

    }

}
