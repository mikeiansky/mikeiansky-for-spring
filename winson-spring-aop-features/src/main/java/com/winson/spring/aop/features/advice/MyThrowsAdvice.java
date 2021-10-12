package com.winson.spring.aop.features.advice;

import org.springframework.aop.ThrowsAdvice;

/**
 * @author winson
 * @date 2021/10/12
 **/
public class MyThrowsAdvice implements ThrowsAdvice {


    public void afterThrowing(Exception e) {
        System.out.println("after exception ... " + e.getMessage());
    }


}
