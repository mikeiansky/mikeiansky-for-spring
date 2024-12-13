package io.github.mikeiansky.spring.v6.overview.annotation;

import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.*;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
public class MultiHierarchicalAnnotatedElementUtilsDemo {

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

        GrandFatherAnnotation grandFatherAnnotation = AnnotatedElementUtils.findMergedAnnotation(One.class, GrandFatherAnnotation.class);
        System.out.println(grandFatherAnnotation);
        FatherAnnotation fatherAnnotation = AnnotatedElementUtils.findMergedAnnotation(One.class, FatherAnnotation.class);
        System.out.println(fatherAnnotation);
        SonAnnotation sonAnnotation = AnnotatedElementUtils.findMergedAnnotation(One.class, SonAnnotation.class);
        System.out.println(sonAnnotation);

    }

}
