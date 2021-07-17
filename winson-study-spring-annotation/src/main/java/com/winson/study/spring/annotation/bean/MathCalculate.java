package com.winson.study.spring.annotation.bean;

/**
 * @author winson
 * @date 2021/7/17
 **/
public class MathCalculate {

    public int div(int a, int b) {
        return a / b;
    }

    public void sayHello(String message) {
        System.out.println("MathCalculate sayHello :: " + message);
    }


}
