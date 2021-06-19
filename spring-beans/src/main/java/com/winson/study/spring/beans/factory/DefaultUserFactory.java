package com.winson.study.spring.beans.factory;

import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @author winson
 * @date 2021/6/19
 **/
public class DefaultUserFactory implements UserFactory, InitializingBean {

    public void initMethod() {
        System.out.println("this is init method ... ");
    }

    @PostConstruct
    public void init() {
        System.out.println("after construct ... ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after properties set ... ");
    }

}
