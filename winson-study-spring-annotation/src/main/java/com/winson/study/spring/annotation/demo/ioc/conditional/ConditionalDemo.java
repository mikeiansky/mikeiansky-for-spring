package com.winson.study.spring.annotation.demo.ioc.conditional;

import com.winson.study.spring.annotation.config.ColorFactoryBean;
import com.winson.study.spring.annotation.config.ConditionalConfig;
import com.winson.study.spring.annotation.utils.ContextUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/7/16
 **/
public class ConditionalDemo {

    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionalConfig.class);
//        Map<String, Person> personMap = context.getBeansOfType(Person.class);
//        System.out.println(personMap);

        ContextUtils.printBeans(context);

        Object obj1 = context.getBean("colorFactoryBean");
        Object obj2 = context.getBean("colorFactoryBean");
        Object obj3 = context.getBean("&colorFactoryBean");
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(((ColorFactoryBean)obj3).getObject());
        System.out.println(((ColorFactoryBean)obj3).getObject());
        System.out.println(obj1 == obj2);

    }

}
