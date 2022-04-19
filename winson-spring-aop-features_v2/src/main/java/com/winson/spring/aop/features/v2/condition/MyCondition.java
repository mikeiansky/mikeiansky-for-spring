package com.winson.spring.aop.features.v2.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;

/**
 * @author winson
 * @date 2022/4/19
 **/
public class MyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        StandardAnnotationMetadata sm = (StandardAnnotationMetadata) metadata;
        System.out.println("MyConditional metadata : " + sm.getClassName());
//        System.out.println("MyConditional info : " + metadata.getAnnotationAttributes(Conditional.class.getName()));

        return true;
    }

}
