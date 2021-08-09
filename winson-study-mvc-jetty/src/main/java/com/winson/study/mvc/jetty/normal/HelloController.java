package com.winson.study.mvc.jetty.normal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author winson
 * @date 2021/7/20
 **/
@Controller
public class HelloController {

    @Autowired
    private ApplicationContext context;

    @RequestMapping("/hello.do")
    public ModelAndView someDo() {
        System.out.println("this is some .do");
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("msg", "this is my message!");
        modelAndView.setViewName("/WEB-INF/views/show.jsp");

        return modelAndView;
    }

}
