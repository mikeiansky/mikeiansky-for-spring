package com.winson.study.spring.mvc.controller.vo;

/**
 * @author winson
 * @date 2021/7/22
 **/
public class Student {

    private String name;
    private Integer age;

    public Student(){
        System.out.println("创建 student");
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
