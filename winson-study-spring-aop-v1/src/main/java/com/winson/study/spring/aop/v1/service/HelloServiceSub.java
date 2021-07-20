package com.winson.study.spring.aop.v1.service;

import com.winson.study.spring.aop.v1.annotation.SayHandle;
import com.winson.study.spring.aop.v1.annotation.Visitor;
import com.winson.study.spring.aop.v1.bean.Human;
import com.winson.study.spring.aop.v1.bean.Man;
import org.springframework.stereotype.Service;

/**
 * @author winson
 * @date 2021/7/19
 **/
@Visitor
@Service
public class HelloServiceSub extends HelloService {

    @SayHandle
    public void subSayHello(String msg) {
        System.out.println("This is sub hello service say hello : " + msg);
    }

    public void sayGoodBye(String msg, int time) {
        System.out.println("sub say good by msg : " + msg + " , time : " + time);
    }

    public void sayHuman(Human human){
        System.out.println("hello say human ==> " + human);
    }

    public void sayMan(Man human){
        System.out.println("hello say man ==> " + human);
    }

}
