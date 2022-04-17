package com.winson.spring.aop.overviewv2;

/**
 * @author winson
 * @date 2022/4/16
 **/
public interface EchoService extends SuperEchoService, GoldEchoService {

    void sayHello(String msg);

    default int getCount() {
        return 1;
    }

}
