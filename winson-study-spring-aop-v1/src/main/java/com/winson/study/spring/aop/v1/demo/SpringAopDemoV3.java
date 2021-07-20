package com.winson.study.spring.aop.v1.demo;

import com.winson.study.spring.aop.v1.bean.Human;
import com.winson.study.spring.aop.v1.config.AopConfigV3;
import com.winson.study.spring.aop.v1.service.HelloService;
import com.winson.study.spring.aop.v1.service.HelloServiceSon;
import com.winson.study.spring.aop.v1.utils.HelpUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/7/20
 **/
public class SpringAopDemoV3 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfigV3.class);
//        HelpUtils.printlnBeanNames(context);

        HelloServiceSon service = context.getBean(HelloServiceSon.class);
//        System.out.println(service);
//        service.sayHello("winson");
//        service.sayHuman(new Human());
        service.sonSayHello("son");


    }

}
