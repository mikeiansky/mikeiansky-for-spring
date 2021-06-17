package com.winson.study.spring.ioc.overview.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;

/**
 * @author winson
 * @date 2021/6/17
 **/
public class UserObjectFactory implements ObjectFactory<User> {

    public User getObject() throws BeansException {
        return new User();
    }

}
