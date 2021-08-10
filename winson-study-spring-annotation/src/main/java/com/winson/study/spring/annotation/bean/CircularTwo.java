package com.winson.study.spring.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author winson
 * @date 2021/8/10
 **/
@Component
public class CircularTwo {

    @Autowired
    private CircularOne circularOne;

}
