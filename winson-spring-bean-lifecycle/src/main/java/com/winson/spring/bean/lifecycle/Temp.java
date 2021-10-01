package com.winson.spring.bean.lifecycle;

/**
 * @author winson
 * @date 2021/10/1
 **/
public class Temp {

    static {
        System.out.println("temp static initialize!");
    }

    public Temp() {
        System.out.println("temp instance initialize!");
    }

}
