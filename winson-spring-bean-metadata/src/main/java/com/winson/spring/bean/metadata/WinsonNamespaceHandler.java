package com.winson.spring.bean.metadata;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class WinsonNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        System.out.println("init name space handler support ");
        registerBeanDefinitionParser("winson", new WinsonBeanDefinitionParser());
    }

}
