package io.github.mikeiansky.spring.v6.overview.annotation.springbase;

import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mike ian
 * @date 2025/5/7
 * @desc
 **/
public class AliasConventionDemo {

    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface First {

        String hello() default "Hello";

    }

    @First
    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Second {

        String hello() default "Hello";

    }

    @Second(hello = "hello one")
    public static class One {

    }

    public static void main(String[] args) {

        AnnotationMetadata metadata = AnnotationMetadata.introspect(One.class);

        MergedAnnotations annotations = metadata.getAnnotations();

        MergedAnnotation<Second> second = annotations.get(Second.class);
        System.out.println(second.getValue("hello"));

        MergedAnnotation<First> first = annotations.get(First.class);
        System.out.println(first.getValue("hello"));


    }

}
