package com.winson.study.spring.annotation.config;

import com.winson.study.spring.annotation.bean.Cat;
import com.winson.study.spring.annotation.bean.Red;
import com.winson.study.spring.annotation.process.MyBeanPostProcess1;
import com.winson.study.spring.annotation.process.MyBeanPostProcess2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author winson
 * @date 2021/7/16
 **/
@Configuration
@ComponentScan(basePackages = {"com.winson.study.spring.annotation.bean"})
@Import({Red.class, MyBeanPostProcess1.class, MyBeanPostProcess2.class})
public class PostProcessConfig {

    @Bean(initMethod = "init")
    public Cat cat() {
        return new Cat();
    }

}
