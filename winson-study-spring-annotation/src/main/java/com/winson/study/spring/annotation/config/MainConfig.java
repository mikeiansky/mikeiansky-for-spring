package com.winson.study.spring.annotation.config;

import com.winson.study.spring.annotation.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author winson
 * @date 2021/7/15
 **/
@Configuration
public class MainConfig {

    @Bean
    public Person person(){
        return new Person("winson", 30);
    }

}
