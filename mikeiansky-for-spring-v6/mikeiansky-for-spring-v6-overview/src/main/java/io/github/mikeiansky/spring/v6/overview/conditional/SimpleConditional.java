package io.github.mikeiansky.spring.v6.overview.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author mike ian
 * @date 2024/12/16
 * @desc
 **/
public class SimpleConditional implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println(context);
        // MissClassNameConditional 可以编译和运行
        System.out.println(metadata.getAnnotations().get(MissClassNameConditional.class).asMap());
        // MissClassConditional 可以编译，但是无法运行，会抛出异常，如果类缺失的话
        return false;
    }

}
