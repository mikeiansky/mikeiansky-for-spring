package com.winson.spring.bean.metadata;

import java.lang.annotation.*;

/**
 * @author winson
 * @date 2022/1/27
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WinsonPlaceholderAnnotation {

    String name() default "zwx";

    String value() default "ciwei";

    String encoding() default "work";

    Class Factory() default TestIf.class;

}
