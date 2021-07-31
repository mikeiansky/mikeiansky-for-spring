package com.winson.study.spring.mvc.controller.exception;

/**
 * @author winson
 * @date 2021/7/31
 **/
public class MyException extends Exception{

    public MyException(){
        super();
    }

    public MyException(String message) {
        super(message);
    }
}
