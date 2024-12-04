package com.winson.spring.dependency.source.demo;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author winson
 * @date 2021/10/3
 **/
public class Sample {

    @Value("${user.address:empty}")
    public String address;

    @Value("${user.age:3}")
    public int age;

}
