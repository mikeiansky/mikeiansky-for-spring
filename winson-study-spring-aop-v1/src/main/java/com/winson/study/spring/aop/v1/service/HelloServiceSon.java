package com.winson.study.spring.aop.v1.service;

import org.springframework.stereotype.Component;

/**
 * @author winson
 * @date 2021/7/19
 **/
@Component
public class HelloServiceSon extends HelloServiceSub {

    public void sonSayHello(String msg) {
        System.out.println("son say hello msg : " + msg);
    }

}
