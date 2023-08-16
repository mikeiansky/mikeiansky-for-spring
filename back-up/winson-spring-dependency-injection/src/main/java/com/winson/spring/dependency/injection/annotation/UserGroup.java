package com.winson.spring.dependency.injection.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * @author winson
 * @date 2021/9/25
 **/
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserGroup {

}
