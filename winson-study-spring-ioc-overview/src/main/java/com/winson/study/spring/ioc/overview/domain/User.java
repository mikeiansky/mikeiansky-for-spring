package com.winson.study.spring.ioc.overview.domain;

import com.winson.study.spring.ioc.overview.annotation.Super;

/**
 * @author winson
 * @date 2021/6/17
 **/
public class User {

    private String name;

    private int age;

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
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static User createUser(){
        User user = new User();
        user.setName("winson");
        user.setAge(26);
        return user;
    }

}
