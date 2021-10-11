package com.winson.spring.bean.metadata;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author winson
 * @date 2021/9/28
 **/
public class TestIf {

    @Value("${winson.age}")
    private String age;

    public static void main(String[] args) {

        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = true;
        boolean b4 = true;
        boolean b5 = true;
        boolean b6 = false;

        if(b3 || !b4 || b5){
            System.out.println("3 true");
        } else {
            System.out.println("3 false");
        }

        if(b2 || (b3 || !b4 || b5) && !b6){
            System.out.println("2 true");
        } else{
            System.out.println("2 false");
        }

        if (!b1 && (b2 || (b3 || !b4 || b5) && !b6)) {
            System.out.println("1 true");
        } else {
            System.out.println("1 false");
        }

    }

    public String getAge() {
        return age;
    }
}
