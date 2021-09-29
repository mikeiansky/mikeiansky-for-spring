package com.winson.spring.bean.metadata;

/**
 * @author winson
 * @date 2021/9/28
 **/
public class TestIfTwo {

    public static void main(String[] args) {

        boolean b1 = false;
        boolean b2 = true;
        boolean b3 = false;

        if (b1 || b2 && b3) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

}
