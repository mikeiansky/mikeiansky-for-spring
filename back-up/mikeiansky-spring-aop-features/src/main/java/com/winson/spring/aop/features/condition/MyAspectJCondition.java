package com.winson.spring.aop.features.condition;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author winson
 * @date 2021/10/11
 **/
public class MyAspectJCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println("MyAspectJCondition matches : " + context);
//        context.getBeanFactory().getMergedBeanDefinition("");
        System.out.println("MyAspectJCondition metadata : " + metadata);
        return true;
    }

}
