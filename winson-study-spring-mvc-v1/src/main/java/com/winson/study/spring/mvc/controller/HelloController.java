package com.winson.study.spring.mvc.controller;

import com.winson.study.spring.mvc.controller.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author winson
 * @date 2021/7/20
 **/
@Controller
public class HelloController {

    @RequestMapping("/some.do")
    public ModelAndView someDo() {
        System.out.println("this is some .do");
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("msg", "this is my message!");
        modelAndView.setViewName("/WEB-INF/views/show.jsp");

        return modelAndView;
    }

    @RequestMapping(value = "/param.do", method = RequestMethod.POST)
    public ModelAndView getDo(Student student) {
//    public ModelAndView getDo(String name, String age) {
        System.out.println("name is : " + student.getName());
        System.out.println("age is : " + student.getAge());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/views/show.jsp");

        return modelAndView;
    }

}
