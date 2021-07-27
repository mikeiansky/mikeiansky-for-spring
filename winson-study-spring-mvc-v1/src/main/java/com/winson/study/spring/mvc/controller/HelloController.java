package com.winson.study.spring.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import com.winson.study.spring.mvc.controller.vo.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/show.do" , method = RequestMethod.GET)
    public String getShow(HttpServletRequest request){
        request.setAttribute("msg", "internal msg");
        return "show";
    }

}
