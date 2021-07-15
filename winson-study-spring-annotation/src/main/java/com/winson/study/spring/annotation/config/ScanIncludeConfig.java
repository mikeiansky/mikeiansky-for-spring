package com.winson.study.spring.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author winson
 * @date 2021/7/15
 **/
@ComponentScan(
        basePackages = "com.winson.study.spring.annotation",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class, Service.class})
        },
        useDefaultFilters = false
)
public class ScanIncludeConfig {
}
