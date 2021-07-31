package com.winson.study.spring.mvc.controller.handler;

import com.winson.study.spring.mvc.controller.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author winson
 * @date 2021/7/31
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyException.class)
    public String handleMyException(MyException exception){
        System.out.println("handle my exception : " + exception.getMessage());
        return "show";
    }

}
