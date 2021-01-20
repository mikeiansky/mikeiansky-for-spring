package com.winson.spring;

import com.winson.spring.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author com.winson
 * @date 2020/12/20
 **/
public class TestSpring {

    @Test
    public void testHelloSpring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("hello-spring.xml");
        Person person = context.getBean(Person.class);
        person.sayHello();
    }

}
