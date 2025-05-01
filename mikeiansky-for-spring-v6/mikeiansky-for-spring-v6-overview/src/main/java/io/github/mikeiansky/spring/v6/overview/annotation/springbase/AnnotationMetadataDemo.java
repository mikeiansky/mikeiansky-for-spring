package io.github.mikeiansky.spring.v6.overview.annotation.springbase;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mike ian
 * @date 2025/5/1
 * @desc
 **/
public class AnnotationMetadataDemo {

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public  @interface AnnotationFlag_01 {
        String hello() default "flag-01";
    }

    @AnnotationFlag_01
    public static class One {

    }

    public static void main(String[] args) {

        AnnotationMetadata annotationMetadata = new StandardAnnotationMetadata(One.class);
        annotationMetadata.hasAnnotation("flag-01");
        annotationMetadata.getAnnotations();

    }

}
