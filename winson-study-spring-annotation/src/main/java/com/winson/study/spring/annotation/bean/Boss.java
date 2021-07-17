package com.winson.study.spring.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author winson
 * @date 2021/7/17
 **/
@Component
public class Boss {

    private Cat cat;

    public Boss(){
        System.out.println("boss 无参构造器 , cat : " + cat);
    }

//    @Autowired
//    public Boss(Cat cat) {
//        System.out.println("boss 有参构造器 ， cat : " + cat);
//    }

}
