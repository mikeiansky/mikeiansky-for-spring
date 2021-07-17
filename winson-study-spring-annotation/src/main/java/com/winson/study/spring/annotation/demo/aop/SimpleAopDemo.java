package com.winson.study.spring.annotation.demo.aop;

import com.winson.study.spring.annotation.aop.SimpleAop;
import com.winson.study.spring.annotation.bean.MathCalculate;
import com.winson.study.spring.annotation.config.SimpleAopConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/7/17
 **/
public class SimpleAopDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SimpleAopConfig.class);

        MathCalculate mathCalculate = context.getBean(MathCalculate.class);
        int result = mathCalculate.div(9, 4);
        System.out.println(result);
//        mathCalculate.sayHello("winson");
//        mathCalculate.div(3, 0);

    }

}
