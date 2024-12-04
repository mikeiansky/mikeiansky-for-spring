package com.winson.spring.aop.overview;

import java.util.Random;

/**
 * @author winson
 * @date 2021/10/8
 **/
public class DefaultEchoService implements EchoService{

    @Override
    public String echo(String message) {

        Random random = new Random();
        Boolean result = random.nextBoolean();
//        if(Boolean.TRUE.equals(result)){
//            throw new RuntimeException(" For Propose ... ");
//        }

//        if(Boolean.TRUE.equals(result) || Boolean.FALSE.equals(result)){
//            throw new RuntimeException(" For Propose ... ");
//        }

        return "[ ECHO ] " + message;
    }

}
