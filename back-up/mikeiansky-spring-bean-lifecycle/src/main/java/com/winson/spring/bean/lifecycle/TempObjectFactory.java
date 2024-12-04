package com.winson.spring.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class TempObjectFactory implements ObjectFactory<Temp> {

    @Override
    public Temp getObject() throws BeansException {
        return new Temp();
    }

}
