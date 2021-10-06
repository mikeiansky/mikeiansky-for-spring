package com.winson.spring.annotation.demo;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author winson
 * @date 2021/10/6
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@MyComponent
public @interface MyComponent2 {
}
