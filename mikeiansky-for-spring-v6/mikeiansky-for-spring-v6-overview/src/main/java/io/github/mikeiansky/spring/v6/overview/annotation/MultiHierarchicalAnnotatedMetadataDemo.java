package io.github.mikeiansky.spring.v6.overview.annotation;

import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
public class MultiHierarchicalAnnotatedMetadataDemo {

    //    @Inherited
    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface GrandFatherAnnotation {
        String gfvalue() default "grandFather";
    }

    //    @Inherited
    @GrandFatherAnnotation(gfvalue = "customize-grand-father")
    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FatherAnnotation {
        String fvalue() default "father";
    }

    @FatherAnnotation(fvalue = "customize-father")
    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SonAnnotation {
        String svalue() default "son";
    }

    @SonAnnotation(svalue = "customize-son")
    public static class One {

    }

    public static void main(String[] args) {
        AnnotationMetadata annotationMetadata = AnnotationMetadata.introspect(One.class);
        System.out.println(annotationMetadata.getAnnotationTypes());
        GrandFatherAnnotation grandFatherAnnotation = annotationMetadata.getAnnotations().get(GrandFatherAnnotation.class).synthesize();
        System.out.println(grandFatherAnnotation);
        FatherAnnotation fatherAnnotation = annotationMetadata.getAnnotations().get(FatherAnnotation.class).synthesize();
        System.out.println(fatherAnnotation);
        SonAnnotation sonAnnotation = annotationMetadata.getAnnotations().get(SonAnnotation.class).synthesize();
        System.out.println(sonAnnotation);

    }

}
