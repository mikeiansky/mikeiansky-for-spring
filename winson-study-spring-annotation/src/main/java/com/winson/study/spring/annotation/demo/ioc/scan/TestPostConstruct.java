package com.winson.study.spring.annotation.demo.ioc.scan;

import com.winson.study.spring.annotation.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author winson
 * @date 2021/8/5
 **/
@Component
public class TestPostConstruct {

    @Autowired
    private Person person;

    @PostConstruct
    public void init(){
        System.out.println("-----> " + person);
    }

}
