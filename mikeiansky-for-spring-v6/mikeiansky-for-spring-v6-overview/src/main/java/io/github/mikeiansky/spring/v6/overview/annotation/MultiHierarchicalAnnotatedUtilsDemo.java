package io.github.mikeiansky.spring.v6.overview.annotation;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.*;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
public class MultiHierarchicalAnnotatedUtilsDemo {

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

        GrandFatherAnnotation grandFatherAnnotation = AnnotationUtils.findAnnotation(One.class, GrandFatherAnnotation.class);
        System.out.println(grandFatherAnnotation);
        FatherAnnotation fatherAnnotation = AnnotationUtils.findAnnotation(One.class, FatherAnnotation.class);
        System.out.println(fatherAnnotation);
        SonAnnotation sonAnnotation = AnnotationUtils.findAnnotation(One.class, SonAnnotation.class);
        System.out.println(sonAnnotation);

    }

}
