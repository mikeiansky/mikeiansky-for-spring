package com.winson.study.spring.aop.v1.service;

import com.winson.study.spring.aop.v1.annotation.SayHandle;
import com.winson.study.spring.aop.v1.annotation.Visitor;
import org.springframework.stereotype.Service;

/**
 * @author winson
 * @date 2021/7/19
 **/
@Visitor
@Service
public class HelloServiceSub extends HelloService{

    @SayHandle
    public void subSayHello(String msg){
        System.out.println("This is sub hello service say hello : " + msg);
    }

}
