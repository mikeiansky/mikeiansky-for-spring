package com.winson.spring.annotation.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author winson
 * @date 2021/10/6
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ComponentScan
public @interface MyComponentScan {

//    @AliasFor(annotation = ComponentScan.class, value = "basePackages")
//    String pkg() default "#";

//    @AliasFor(attribute = "value", annotation = ComponentScan.class)
//    String forAlisValue() default ("#");

    // "多态"，子注解提供新的属性方法引用"父"（元）注解中的属性方法
//    @AliasFor(annotation = ComponentScan.class, attribute = "value") // 隐性别名
//    String[] scanBasePackages2() default {"#"};


        @AliasFor(annotation = ComponentScan.class, value = "value")
        String[] pkg() default {};

}
