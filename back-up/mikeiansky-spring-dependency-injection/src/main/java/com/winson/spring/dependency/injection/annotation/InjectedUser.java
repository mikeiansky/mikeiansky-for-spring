package com.winson.spring.dependency.injection.annotation;

import java.lang.annotation.*;

/**
 * @author winson
 * @date 2021/9/25
 **/
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectedUser {


}
