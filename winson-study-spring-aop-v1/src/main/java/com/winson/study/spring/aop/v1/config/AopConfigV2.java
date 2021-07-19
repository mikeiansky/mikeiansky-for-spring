package com.winson.study.spring.aop.v1.config;

import com.winson.study.spring.aop.v1.aop.AopAspectV2;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author winson
 * @date 2021/7/19
 **/
@ComponentScan(basePackages = "com.winson.study.spring.aop.v1.service")
@EnableAspectJAutoProxy
public class AopConfigV2 {

    @Bean
    public AopAspectV2 aopAspectV2(){
        return new AopAspectV2();
    }

}
