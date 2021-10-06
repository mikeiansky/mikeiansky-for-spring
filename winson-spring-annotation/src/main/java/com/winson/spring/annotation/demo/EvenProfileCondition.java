package com.winson.spring.annotation.demo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author winson
 * @date 2021/10/6
 **/
public class EvenProfileCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        for (String profile : context.getEnvironment().getActiveProfiles()) {
//
//        }
        return context.getEnvironment().acceptsProfiles("even");
    }

}
