package com.winson.study.spring.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.winson.study.spring.mvc.controller.exception.MyException;
import com.winson.study.spring.mvc.controller.pojo.WinsonUser;
import com.winson.study.spring.mvc.controller.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author winson
 * @date 2021/7/20
 **/
@Controller
public class HelloController {

    @Autowired
    private ApplicationContext context;

    @RequestMapping(value = "/name.do", method = RequestMethod.POST)
    public ModelAndView nameDo(String name) {
        System.out.println("this is name .do : " + name);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("msg", "this is name do!");
//        modelAndView.setViewName("/WEB-INF/views/show.jsp");

        return modelAndView;
    }

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

    @ResponseBody
    @RequestMapping(value = "/saveInfo.do", method = RequestMethod.POST)
    public void getStudentInfo(HttpServletResponse response, Student student) {
        System.out.println("get student info name : " + student.getName() + " , age : " + student.getAge());
        Map<String, HttpMessageConverter> beans = context.getBeansOfType(HttpMessageConverter.class);
        System.out.println("get student info beans : " + beans);
//        student.setName("文翔");
        System.out.println("response : " + response);
        response.setHeader("Content-Type", "application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        try {
            String result = mapper.writer().writeValueAsString(student);
            System.out.println("save info result : " + result);
            response.getWriter().write(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @ResponseBody
    @RequestMapping(value = "/saveInfo2.do", method = RequestMethod.POST)
    public Student getStudentInfo(Student student) {
        System.out.println("get student v2 info name : " + student.getName() + " , age : " + student.getAge());
        return student;
    }

    @RequestMapping(value = "show.do", method = RequestMethod.GET)
    public String getShow(HttpServletRequest request) {
        System.out.println("request show");
        request.setAttribute("msg", "internal msg");
        return "show";
    }

    @RequestMapping("user/show.do")
    public String userShow(HttpServletRequest request) {
        System.out.println("request user show");
        return "some";
    }

    @RequestMapping("/forward")
    public ModelAndView forward() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "[haha]");
        mav.setViewName("forward:/WEB-INF/views/forward.jsp");
        return mav;
    }

    @RequestMapping("/redirect")
    public ModelAndView redirect() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "[redirect]");
        mav.setViewName("redirect:/redirect.jsp");
        return mav;
    }

    @RequestMapping("/exception")
    public String exception() throws MyException {
        ModelAndView mav = new ModelAndView();
        if (1 == 1) {
            throw new MyException("this is my exception");
        }
        return "hello";
    }

    @RequestMapping(value = "user.do", method = RequestMethod.POST)
    public String user(@RequestBody WinsonUser winsonUser){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String result = mapper.writeValueAsString(winsonUser);
            System.out.println("winson user result : " + result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

//        System.out.println("winson user ----> : " + );
        return "hello";
    }

}
