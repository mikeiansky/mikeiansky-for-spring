package com.winson.study.spring.mvc.shiro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author winson
 * @date 2021/9/13
 **/
@Controller
public class WinsonControl {

    static {
        System.out.println("winson contorl init");
    }

    @RequestMapping("/say")
    public String sayHello(){
        System.out.println(" winson say hello -----> ");
        return "index.jsp";
    }

}
