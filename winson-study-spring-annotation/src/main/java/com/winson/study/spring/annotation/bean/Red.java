package com.winson.study.spring.annotation.bean;

import javax.annotation.PostConstruct;

/**
 * @author winson
 * @date 2021/7/16
 **/
public class Red {

    @PostConstruct
    public void redConstruct(){
        System.out.println("red construct");
    }

}
