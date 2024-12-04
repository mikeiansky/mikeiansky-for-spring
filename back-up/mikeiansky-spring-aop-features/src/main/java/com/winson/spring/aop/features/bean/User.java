package com.winson.spring.aop.features.bean;

/**
 * @author winson
 * @date 2021/10/15
 **/
public class User {

    private String name;

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void sayHello(String msg){
        System.out.println("user say : " + msg);
    }

}
