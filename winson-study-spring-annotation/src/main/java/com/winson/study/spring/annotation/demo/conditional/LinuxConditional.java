package com.winson.study.spring.annotation.demo.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Locale;

/**
 * @author winson
 * @date 2021/7/16
 **/
public class LinuxConditional implements Condition {
    
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String osName = conditionContext.getEnvironment().getProperty("os.name");
        return osName.toLowerCase(Locale.ROOT).contains("linux");
    }

}
