package com.winson.spring.aop.features;

import org.springframework.aop.ThrowsAdvice;

/**
 * @author winson
 * @date 2021/10/9
 **/
public class MyThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Throwable throwable){
        System.out.println("after throw exception ... " + throwable.getMessage());
    }

}
