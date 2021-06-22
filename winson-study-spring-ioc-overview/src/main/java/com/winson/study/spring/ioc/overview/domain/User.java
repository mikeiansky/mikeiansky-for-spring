package com.winson.study.spring.ioc.overview.domain;

import com.winson.study.spring.ioc.overview.annotation.Super;
import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author winson
 * @date 2021/6/17
 **/
public class User implements BeanNameAware {

    private long id;

    private String name;

    private int age;

    private transient String beanName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static User createUser(){
        User user = new User();
        user.setName("winson");
        user.setAge(26);
        return user;
    }

    @PostConstruct
    public void init(){
        System.out.println("user bean name ["+beanName+"] init");
    }

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }

    @PreDestroy
    public void destroy(){
        System.out.println("user bean name ["+beanName+"] destroy");
    }

}
