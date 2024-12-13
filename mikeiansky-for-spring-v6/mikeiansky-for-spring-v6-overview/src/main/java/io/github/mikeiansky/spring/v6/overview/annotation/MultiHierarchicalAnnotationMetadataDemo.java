package io.github.mikeiansky.spring.v6.overview.annotation;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
public class MultiHierarchicalAnnotationMetadataDemo {

    @Inherited
    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface GrandFatherAnnotation {
        String gfvalue() default "grandFather";
    }

    @Inherited
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
        System.out.println("overview ==== > ");
        System.out.println(annotationMetadata);
        System.out.println("getAnnotationTypes ==== > ");
        System.out.println(annotationMetadata.getAnnotationTypes());
        System.out.println("getAnnotations ==== > ");
        annotationMetadata.getAnnotations().stream().forEach(new Consumer<MergedAnnotation<Annotation>>() {
            @Override
            public void accept(MergedAnnotation<Annotation> annotationMergedAnnotation) {
                System.out.println(annotationMergedAnnotation.asMap());
            }
        });
        System.out.println("hasAnnotation ==== > ");
        boolean hasSonAnnotation = annotationMetadata.hasAnnotation(SonAnnotation.class.getName());
        System.out.println("hasSonAnnotation = " + hasSonAnnotation);
        boolean hasFatherAnnotation = annotationMetadata.hasAnnotation(FatherAnnotation.class.getName());
        System.out.println("hasFatherAnnotation = " + hasFatherAnnotation);
        boolean hasGrandFatherAnnotation = annotationMetadata.hasAnnotation(GrandFatherAnnotation.class.getName());
        System.out.println("hasGrandFatherAnnotation = " + hasGrandFatherAnnotation);

    }

}
