package com.winson.spring.study.bean.lifecycle;

import com.winson.study.spring.ioc.overview.domain.SuperUser;
import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

/**
 * @author winson
 * @date 2021/6/26
 **/
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(ObjectUtils.nullSafeEquals("superUser", beanName) && SuperUser.class.equals(beanClass)){
            return new SuperUser();
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())){
            User user = (User) bean;
            user.setId(2L);
            user.setName("winson");
            return false;
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println("postProcessProperties ---> beanName : " + beanName);
        if(ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())){
            MutablePropertyValues mpv = new MutablePropertyValues();
            mpv.addPropertyValue("number", "2");
            mpv.addPropertyValue("description", "user holder -v2");
            return mpv;
        }
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessBeforeInitialization beanName : " + beanName + " , bean : " + bean);
        if(ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())){
            UserHolder userHolder = (UserHolder) bean;
            userHolder.setDescription("user holder - v3");
        }
        return bean;
    }
}
