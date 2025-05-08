package io.github.mikeiansky.spring.v6.overview.annotation.utils;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mike ian
 * @date 2025/5/8
 * @desc
 **/
public class AnnotationConfigUtilsDemo {

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD , ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface GrandFatherAnnotation {
        String hello() default "hello";
    }

    @AnnotationUtilsDemo.GrandFatherAnnotation(hello = "hello father")
    @Target({ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FatherAnnotation {
        String good() default "good";
    }

    @Primary
    @Lazy
    @AnnotationUtilsDemo.FatherAnnotation(good = "good one")
    public static class One {

    }

    public static void main(String[] args) {

        AnnotatedGenericBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(One.class);
        System.out.println(beanDefinition);
        AnnotationConfigUtils.processCommonDefinitionAnnotations(beanDefinition);
        System.out.println(beanDefinition);

    }

}
