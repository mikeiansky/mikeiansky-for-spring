package com.winson.spring.aop.overview;

/**
 * @author winson
 * @date 2021/10/8
 **/
public class DefaultEchoService implements EchoService{

    @Override
    public String echo(String message) {
        return "[ ECHO ] " + message;
    }

}
