package com.winson.spring.annotation.demo;

import java.lang.annotation.*;

/**
 * @author winson
 * @date 2021/10/6
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WinsonAnnotation {

    String winsonName() default "winson-name-wenxiang";

    int winsonAge() default 29;

}
