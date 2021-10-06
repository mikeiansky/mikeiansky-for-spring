package com.winson.spring.annotation.demo;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author winson
 * @date 2021/10/6
 **/
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
//@Import(HelloConfig.class)
//@Import(HelloImportSelector.class)
//@Import(HelloImportRegistrar.class)
@Import({HelloConfig.class, HelloImportSelector.class, HelloImportRegistrar.class})
public @interface EnableHello {


}
