package com.winson.study.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author winson
 * @date 2021/7/20
 **/
@Controller
public class HelloController {

    @RequestMapping("/some.do")
    public ModelAndView someDo(){
        System.out.println("this is some .do");
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("msg", "this is my message!");
        modelAndView.setViewName("/show.jsp");

        return modelAndView;
    }

}
