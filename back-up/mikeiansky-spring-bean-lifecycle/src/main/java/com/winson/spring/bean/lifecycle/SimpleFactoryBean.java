package com.winson.spring.bean.lifecycle;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class SimpleFactoryBean implements FactoryBean<Temp> {

    @Override
    public Temp getObject() throws Exception {
        return new Temp();
    }

    @Override
    public Class<?> getObjectType() {
        return Temp.class;
    }

}
