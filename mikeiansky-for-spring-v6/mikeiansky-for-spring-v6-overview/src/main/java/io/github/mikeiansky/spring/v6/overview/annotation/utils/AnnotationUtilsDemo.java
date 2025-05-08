package io.github.mikeiansky.spring.v6.overview.annotation.utils;

import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mike ian
 * @date 2025/5/8
 * @desc
 **/
public class AnnotationUtilsDemo {

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD , ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface GrandFatherAnnotation {
        String hello() default "hello";
    }

    @GrandFatherAnnotation(hello = "hello father")
    @Target({ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FatherAnnotation {
        String good() default "good";
    }

    @FatherAnnotation(good = "good one")
    public static class One {

    }

    public static void main(String[] args) {
        GrandFatherAnnotation grandFatherAnnotation = AnnotationUtils.findAnnotation(One.class, GrandFatherAnnotation.class);
        System.out.println(grandFatherAnnotation);

        FatherAnnotation fatherAnnotation = AnnotationUtils.findAnnotation(One.class, FatherAnnotation.class);
        System.out.println(fatherAnnotation);
    }


}
