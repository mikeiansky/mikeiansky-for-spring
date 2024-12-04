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
@MyComponentScan
public @interface MyComponentScan2 {

//    @AliasFor(annotation = ComponentScan.class, value = "basePackages")
//    String forBP() default "#";
//
//    @AliasFor(annotation = MyComponentScan.class, value = "pkg")
//    String subPkg() default "#";
//
//    @AliasFor(annotation = MyComponentScan.class, attribute = "pkg")
//    String subAtPkg() default "#";

//    String pkg() default "#";
//
//    @AliasFor("pkg")
//    String overridePkg() default "#";


//    @AliasFor(annotation = MyComponentScan.class, attribute = "pkg") // 隐性别名
//    String[] basePackages() default {};
//
//    /**
//     * 与元注解 @MyComponentScan 同名属性
//     *
//     * @return
//     */
//    String[] scanBasePackages2() default {};
//
//    @AliasFor("scanBasePackages2")
//    String[] packages2() default {}; // packages 覆盖了 scanBasePackages 覆盖了元注解 scanBasePackages

    @AliasFor(annotation = MyComponentScan.class, value = "pkg")
    String[] forPkg() default {};

    String[] pkg() default {};

    @AliasFor("pkg")
    String[] opkg() default {};

}
