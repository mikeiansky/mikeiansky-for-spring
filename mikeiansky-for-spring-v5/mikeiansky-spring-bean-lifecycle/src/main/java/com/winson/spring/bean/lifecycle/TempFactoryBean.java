package com.winson.spring.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.ObjectFactory;

/**
 * @author winson
 * @date 2021/10/1
 **/
public class TempFactoryBean implements FactoryBean<Temp> , BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public Temp getObject() throws Exception {
        System.out.println("temp factory bean getObject()");
        return beanFactory.getBean(Temp.class);
    }

    @Override
    public Class<?> getObjectType() {
//        System.out.println("temp factory bean getObjectType()");
        return FactoryBean.class;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("set bean factory ----> ");
        this.beanFactory = beanFactory;
    }
}
