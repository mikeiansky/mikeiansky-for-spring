package com.winson.spring.bean.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;

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
}
