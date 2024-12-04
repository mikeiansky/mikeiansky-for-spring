package com.winson.spring.aop.overview;

import java.lang.reflect.Method;

/**
 * @author winson
 * @date 2021/10/8
 **/
public interface BeforeInterceptor {

    Object before(Object obj, Method method, Object[] args);

}
