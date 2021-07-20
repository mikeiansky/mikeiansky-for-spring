package com.winson.study.spring.aop.v1.config;

import com.winson.study.spring.aop.v1.aop.AopAspect;
import com.winson.study.spring.aop.v1.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author winson
 * @date 2021/7/19
 **/
@Configuration
@ComponentScan(basePackages = "com.winson.study.spring.aop.v1")
@EnableAspectJAutoProxy
public class AopConfig {

//    @Bean
//    public HelloService helloService(){
//        return new HelloService();
//    }
//
//    @Bean
//    public AopAspect aopAspect(){
//        return new AopAspect();
//    }

}
