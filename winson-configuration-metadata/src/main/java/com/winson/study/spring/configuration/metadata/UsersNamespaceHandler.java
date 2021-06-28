package com.winson.study.spring.configuration.metadata;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author winson
 * @date 2021/6/28
 **/
public class UsersNamespaceHandler  extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }

}
