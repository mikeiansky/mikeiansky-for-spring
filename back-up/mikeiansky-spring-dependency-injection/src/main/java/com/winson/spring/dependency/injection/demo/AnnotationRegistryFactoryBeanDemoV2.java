package com.winson.spring.dependency.injection.demo;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2022/3/13
 **/
public class AnnotationRegistryFactoryBeanDemoV2 implements FactoryBean<AnnotationRegistryFactoryBeanDemoV2.MyHello>{

    public static class MyHello{

    }

    @Override
    public MyHello getObject() throws Exception {
        System.out.println("getObject @@ MyHello");
        return new MyHello();
    }

    @Override
    public Class<? extends MyHello> getObjectType() {
        return MyHello.class;
    }

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationRegistryFactoryBeanDemoV2.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String resourcePath = "classpath:/winson-spring-overview.xml";
        reader.loadBeanDefinitions(resourcePath);

        context.refresh();

        AnnotationRegistryFactoryBeanDemoV2 demo = context.getBean(AnnotationRegistryFactoryBeanDemoV2.class);
        System.out.println("demo : " + demo);
        MyHello myHello1 = context.getBean(MyHello.class);
        System.out.println("myHello1 : " + myHello1);
        MyHello myHello2 = context.getBean(MyHello.class);
        System.out.println("myHello2 : " + myHello2);
        MyHello myHello3 = context.getBean(MyHello.class);
        System.out.println("myHello3 : " + myHello3);


    }


}
