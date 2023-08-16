package com.winson.spring.dependency.source.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2021/10/3
 **/
public class ClassPathContextDemo {

    public static void main(String[] args) {

        String path = "classpath:/META-INF/temp-context.xml";
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{path}, false);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
//        System.out.println(context.getBeanFactory());
        context.refresh();
        System.out.println(context.getBeanDefinitionCount());
        Temp temp = context.getBean(Temp.class);
        System.out.println("temp : " + temp);
        System.out.println("temp.address : " + temp.address);

    }

}
