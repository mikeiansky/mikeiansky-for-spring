package com.winson.study.dubbo.service.impl;

import com.winson.study.dubbo.service.ProviderService;

/**
 * @author winson
 * @date 2021/8/9
 **/
public class ProviderServiceImpl implements ProviderService {

    @Override
    public String sayHello(String msg) {
        System.out.println("run at service , msg is : " + msg);
        return "winson say hello : " + msg;
    }

}
