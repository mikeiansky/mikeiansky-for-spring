package com.winson.study.spring.annotation.config;

import com.winson.study.spring.annotation.aop.SimpleAop;
import com.winson.study.spring.annotation.bean.MathCalculate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author winson
 * @date 2021/7/17
 **/
@EnableAspectJAutoProxy
@Configuration
public class SimpleAopConfig {

    @Bean
    public MathCalculate mathCalculate(){
        return new MathCalculate();
    }

    @Bean
    public SimpleAop simpleAop(){
        return new SimpleAop();
    }

}
