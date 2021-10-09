package com.winson.spring.bean.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @author winson
 * @date 2021/10/7
 **/
public class CycleOne {

    @Autowired
    private CycleTwo cycleTwo;

    public CycleTwo getCycleTwo() {
        return cycleTwo;
    }

    @Bean
    public String winsonName(){
        return "winson";
    }

}
