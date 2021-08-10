package com.winson.study.spring.annotation.demo.ioc.scan;

import com.winson.study.spring.annotation.aop.SimpleAop;
import com.winson.study.spring.annotation.bean.CircularOne;
import com.winson.study.spring.annotation.bean.Person;
import com.winson.study.spring.annotation.config.ScanAllConfig;
import com.winson.study.spring.annotation.utils.ContextUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Map;

/**
 * @author winson
 * @date 2021/7/15
 **/
public class ScanAllDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanAllConfig.class);
//        String[] beanNames = context.getBeanDefinitionNames();
//        Arrays.stream(beanNames).forEach(System.out::println);
//        System.out.println(System.getProperty("os.name"));
//        Map<String, Person> personMap = context.getBeansOfType(Person.class);
//        System.out.println(personMap);

//        Map<String,ContextUtils> aopMap = context.getBeansOfType(ContextUtils.class);
//        System.out.println(aopMap);

        Map<String,CircularOne> circularMap = context.getBeansOfType(CircularOne.class);
        System.out.println(circularMap);

    }

}
