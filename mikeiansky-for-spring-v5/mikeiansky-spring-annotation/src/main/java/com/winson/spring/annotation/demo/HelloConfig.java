package com.winson.spring.annotation.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author winson
 * @date 2021/10/6
 **/
@Configuration
public class HelloConfig {

    @Bean
    public String hello() {
        return "winson";
    }

}
