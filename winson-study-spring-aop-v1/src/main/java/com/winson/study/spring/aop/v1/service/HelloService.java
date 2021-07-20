package com.winson.study.spring.aop.v1.service;

import com.winson.study.spring.aop.v1.annotation.Admin;
import com.winson.study.spring.aop.v1.annotation.SayHandle;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author winson
 * @date 2021/7/19
 **/
@Admin
@Service
@Primary
public class HelloService {

    @SayHandle
    public void sayHello(String msg){
        System.out.println("hello service say hello : " + msg);
    }

}
