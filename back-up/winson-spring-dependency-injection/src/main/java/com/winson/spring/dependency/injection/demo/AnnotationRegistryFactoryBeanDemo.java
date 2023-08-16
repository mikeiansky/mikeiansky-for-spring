package com.winson.spring.dependency.injection.demo;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2022/3/13
 **/
public class AnnotationRegistryFactoryBeanDemo implements FactoryBean<User>, BeanFactoryAware {

    public static class Hello {

    }

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public User getObject() throws Exception {
        System.out.println("getObject @@ User");
//        return beanFactory.getBean(User.class);
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class; // 可以
//        return AnnotationRegistryFactoryBeanDemo.class; // 不行
    }

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationRegistryFactoryBeanDemo.class);

//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
//        String resourcePath = "classpath:/winson-spring-overview.xml";
//        reader.loadBeanDefinitions(resourcePath);

        context.refresh();

        AnnotationRegistryFactoryBeanDemo demo = context.getBean(AnnotationRegistryFactoryBeanDemo.class);
//        Hello Hello = context.getBean(Hello.class);
        System.out.println("demo : " + demo);
        // 取getObject
        System.out.println("value-demo : " + context.getBean("annotationRegistryFactoryBeanDemo"));
        System.out.println("value-demo : " + context.getBean("annotationRegistryFactoryBeanDemo"));
        // 取demo本身
        System.out.println("&demo : " + context.getBean("&annotationRegistryFactoryBeanDemo"));
//        System.out.println("&&demo : " + context.getBean("&&annotationRegistryFactoryBeanDemo"));
//        System.out.println("&&&demo : " + context.getBean("&&&&annotationRegistryFactoryBeanDemo"));
        System.out.println("User : " + context.getBean(User.class));
//        System.out.println(context.getBean(AnnotationRegistryFactoryBeanDemo.class));
//        System.out.println(demo.getObject());

    }


}
