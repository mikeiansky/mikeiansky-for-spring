package com.winson.study.spring.annotation.demo.ioc.profile;

import com.winson.study.spring.annotation.config.ProfileConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author winson
 * @date 2021/7/17
 **/
public class ProfileDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProfileConfig.class);

        Map<String,DataSource> dataSourceMap = context.getBeansOfType(DataSource.class);
        System.out.println(dataSourceMap);


    }

}
