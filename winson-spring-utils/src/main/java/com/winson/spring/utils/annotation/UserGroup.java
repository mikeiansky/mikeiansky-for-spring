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
@User(name = "group-user-default", age = 11)
public @interface UserGroup {

    String groupName() default "default-user-group";

    int groupCount() default 3333;

}
