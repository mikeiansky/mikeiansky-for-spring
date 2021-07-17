package com.winson.study.spring.annotation.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author winson
 * @date 2021/7/16
 **/
public class Cat implements DisposableBean, InitializingBean, ApplicationContextAware {

    @Autowired
    private Boss boss;

    public Cat() {
        System.out.println("cat construct");
        System.out.println("cat boss : " + boss);
    }

    @Autowired
    private Red red;

    public void init() {
        System.out.println("cat init");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("cat post construct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("cat pre destroy");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("cat destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("cat set application");
    }
}
