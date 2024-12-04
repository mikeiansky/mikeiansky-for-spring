package com.winson.spring.dependency.injection.demo;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2022/3/13
 **/
public class AutowireObjectFactoryFieldDemo {

    @Autowired
    private ObjectFactory<User> objectFactoryField;

    @Autowired
    private ObjectProvider<User> objectProviderField;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AutowireObjectFactoryFieldDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String xmlClassPath = "classpath:/winson-spring-overview.xml";
        reader.loadBeanDefinitions(xmlClassPath);

        context.refresh();

        System.out.println(context.getBean(User.class));
        System.out.println(context.getBean(AutowireObjectFactoryFieldDemo.class).objectFactoryField);
        System.out.println(context.getBean(AutowireObjectFactoryFieldDemo.class).objectFactoryField.getObject());
        // 这样也可以
        System.out.println(((ObjectProvider)context.getBean(AutowireObjectFactoryFieldDemo.class).objectFactoryField).getIfAvailable());
        System.out.println(context.getBean(AutowireObjectFactoryFieldDemo.class).objectProviderField);
        System.out.println(context.getBean(AutowireObjectFactoryFieldDemo.class).objectProviderField.getObject());
        System.out.println(context.getBean(AutowireObjectFactoryFieldDemo.class).objectProviderField.getIfAvailable());

    }

}
