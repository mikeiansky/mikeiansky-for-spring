package com.winson.study.spring.annotation.config;

import com.winson.study.spring.annotation.bean.Person;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author winson
 * @date 2021/7/15
 **/
//@ComponentScan(basePackages = "com.winson.study.spring.annotation",
//excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})
//})
@ComponentScan(basePackages = "com.winson.study.spring.annotation",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = {"com.winson.study.spring.annotation.config.*"})
        })
public class ScanExcludeConfig {
}
