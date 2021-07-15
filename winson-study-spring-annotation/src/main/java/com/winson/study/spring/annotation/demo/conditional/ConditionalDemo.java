package com.winson.study.spring.annotation.demo.conditional;

import com.winson.study.spring.annotation.bean.Person;
import com.winson.study.spring.annotation.config.ConditionalConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author winson
 * @date 2021/7/16
 **/
public class ConditionalDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionalConfig.class);
        Map<String, Person> personMap = context.getBeansOfType(Person.class);
        System.out.println(personMap);

    }

}
