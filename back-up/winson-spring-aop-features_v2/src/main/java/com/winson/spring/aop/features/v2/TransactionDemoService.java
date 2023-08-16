package com.winson.spring.aop.features.v2;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author winson
 * @date 2022/4/20
 **/
public interface TransactionDemoService {

    @Transactional(rollbackFor = Throwable.class)
//    @Transactional
    void testTransaction() throws Throwable;

}
