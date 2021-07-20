package com.winson.study.spring.aop.v1.config;

import com.winson.study.spring.aop.v1.aop.AopAspect;
import com.winson.study.spring.aop.v1.aop.AopAspectV3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author winson
 * @date 2021/7/20
 **/
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = "com.winson.study.spring.aop.v1.service")
public class AopConfigV3 {

    @Bean
    public AopAspectV3 aopAspect(){
        return new AopAspectV3();
    }

}
