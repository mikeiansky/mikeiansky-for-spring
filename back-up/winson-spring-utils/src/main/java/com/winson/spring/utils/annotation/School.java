package com.winson.spring.utils.annotation;

import java.lang.annotation.*;

/**
 * @author winson
 * @date 2021/10/12
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD,
        ElementType.METHOD, ElementType.TYPE_PARAMETER,
        ElementType.CONSTRUCTOR, ElementType.PARAMETER,
        ElementType.TYPE})
@Documented
@Inherited
public @interface School {

    String address() default "default-school";

    int size() default 1111;

}
