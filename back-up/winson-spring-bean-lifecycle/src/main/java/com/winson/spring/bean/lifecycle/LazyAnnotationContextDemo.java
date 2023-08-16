package com.winson.spring.bean.lifecycle;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class LazyAnnotationContextDemo {

    @Autowired
    @Lazy
    private Temp temp;

    @Lazy // 这里不影响ObjectProvider或者 ObjectFactory类型注入
    @Autowired
    private ObjectProvider<Temp> tempObjectProvider;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(LazyAnnotationContextDemo.class);

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Temp.class);
        beanDefinition.setLazyInit(true);
        context.registerBeanDefinition("temp", beanDefinition);

        System.out.println("before refresh ======= ");
        context.refresh();
        System.out.println("after refresh ======= ");

//        LazyAnnotationContextDemo demo = context.getBean(LazyAnnotationContextDemo.class);
//        System.out.println("demo : " + demo);
//        System.out.println("--- split --- ");
//        System.out.println("demo.temp1 : " + demo.temp);
//        System.out.println("demo.temp2 : " + demo.temp);

        context.getBean(LazyAnnotationContextDemo.class);
        System.out.println("demo : " + context.getBean(LazyAnnotationContextDemo.class));
        System.out.println("--- split --- ");
        System.out.println("demo.temp3 : " + context.getBean(LazyAnnotationContextDemo.class).temp);
        System.out.println("demo.temp4 : " + context.getBean(LazyAnnotationContextDemo.class).temp);
        System.out.println("demo.temp5 : " + context.getBean(LazyAnnotationContextDemo.class).tempObjectProvider.getObject());

//        System.out.println(context.getBean(Temp.class));

        context.close();

    }

}
