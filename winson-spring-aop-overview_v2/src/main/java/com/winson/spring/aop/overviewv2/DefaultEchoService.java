package com.winson.spring.aop.overviewv2;

import java.io.Serializable;

/**
 * @author winson
 * @date 2022/4/16
 **/
public class DefaultEchoService implements EchoService, Serializable {

    @Override
    public void sayHello(String msg) {
        msg.length();
        System.out.println("hello msg : " + msg + " , I'm default echo service!");
    }

}
