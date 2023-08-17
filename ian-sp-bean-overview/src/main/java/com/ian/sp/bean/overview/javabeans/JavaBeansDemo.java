package com.ian.sp.bean.overview.javabeans;

import com.ian.sp.bean.overview.domain.User;

import java.beans.*;

/**
 * @author mike ian
 * @date 2023/8/17
 * @desc
 **/
public class JavaBeansDemo {

    public static class EditSupport extends PropertyEditorSupport {

        @Override
        public void setValue(Object value) {
            super.setValue(value);
            System.out.println("setValue : " + value);
        }

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            super.setAsText(text);
            System.out.println("setAsText : " + text);
        }
    }

    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);

        System.out.println(beanInfo.getBeanDescriptor().getName());

        System.out.println(beanInfo.getPropertyDescriptors());

        for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
            System.out.println("------------------");
            System.out.println(descriptor.getName());
            System.out.println(descriptor.getPropertyType());
            descriptor.setPropertyEditorClass(EditSupport.class);

            descriptor.setValue("name", "winson");
        }

    }

}
