package com.winson.study.spring.aop.v1.demo;

import com.winson.study.spring.aop.v1.bean.Human;
import com.winson.study.spring.aop.v1.bean.Woman;
import com.winson.study.spring.aop.v1.config.AopConfigV2;
import com.winson.study.spring.aop.v1.service.HelloService;
import com.winson.study.spring.aop.v1.service.HelloServiceSon;
import com.winson.study.spring.aop.v1.service.HelloServiceSub;
import com.winson.study.spring.aop.v1.utils.HelpUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/7/19
 **/
public class SpringAopDemoV2 {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfigV2.class);
//        HelpUtils.printlnBeanNames(context);

//        HelloServiceSub sub = context.getBean("helloServiceSub", HelloServiceSub.class);
//        sub.subSayHello("sub night");

        HelloServiceSon son = context.getBean(HelloServiceSon.class);
//        son.sayGoodBye("son night", 30);
        son.sayHuman(new Woman());

    }


}

