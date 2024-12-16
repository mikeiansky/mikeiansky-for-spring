package io.github.mikeiansky.spring.v6.overview.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
public class AliasForAnnotatedElementUtilsDemo {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FatherAnnotation {

        String helloFather() default "hello-father";

    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @FatherAnnotation(helloFather = "hell-father-son")   // 这里必须要做
    public @interface SonAnnotation {

        @AliasFor(annotation = FatherAnnotation.class, value = "helloFather")
        String helloSon() default "hello-son";


    }

    @SonAnnotation(helloSon = "hello-son-one")
    public static class One {



    }

    public static void main(String[] args) {
        FatherAnnotation fatherAnnotation = AnnotatedElementUtils.findMergedAnnotation(One.class, FatherAnnotation.class);
        System.out.println("fatherAnnotation :: " + fatherAnnotation);
        SonAnnotation sonAnnotation = AnnotatedElementUtils.findMergedAnnotation(One.class, SonAnnotation.class);
        System.out.println("sonAnnotation :: " + sonAnnotation);
    }

}
