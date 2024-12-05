package com.winson.spring.aop.overview;

import java.lang.reflect.Method;

/**
 * @author winson
 * @date 2021/10/8
 **/
public class TimeSpendInterceptor implements FinallyInterceptor{

    private Long startTime;
    private Long endTime;

    public TimeSpendInterceptor(Long startTime, Long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public Object finalize(Object obj, Method method, Object[] args, Object result) {
        return endTime - startTime;
    }

}
