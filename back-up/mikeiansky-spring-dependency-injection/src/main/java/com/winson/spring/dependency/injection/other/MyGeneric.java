package com.winson.spring.dependency.injection.other;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author winson
 * @date 2022/3/20
 **/
public class MyGeneric<T> {

    // 注解的泛型测试
    @Autowired
    @Qualifier("user-generic")
    protected T userGeneric;

}
