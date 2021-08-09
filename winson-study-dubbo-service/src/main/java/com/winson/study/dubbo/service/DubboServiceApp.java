package com.winson.study.dubbo.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author winson
 * @date 2021/8/9
 **/
public class DubboServiceApp {

    public static void main(String[] args) {
        //加载xml配置文件启动
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/provider.xml");
        context.start();
        System.out.println("dubbo start success ---> ");
        try {
            System.in.read(); // 按任意键退出
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("main end --------> ");
    }

}
