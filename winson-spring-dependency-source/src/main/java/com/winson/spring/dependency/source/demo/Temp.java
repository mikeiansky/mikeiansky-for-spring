package com.winson.spring.dependency.source.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author winson
 * @date 2021/10/3
 **/
@Configuration
@PropertySource("classpath:/default-source.properties")
public class Temp {

    static {
        System.out.println("Temp class initialized.");
    }

    @Value("${user.address}")
    public String address;

    public Temp(){
        System.out.println("Temp object initialized.");
    }

}
