package com.winson.spring.generic;

import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.*;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author winson
 * @date 2021/10/5
 **/
@AnnotatedDemo.WinsonAnnotationThree("runtime-three")
public class AnnotatedDemo {

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
    @Inherited
    public @interface WinsonAnnotationOne {
        String value() default "one";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
    @Inherited
    @WinsonAnnotationOne("runtime-one")
    public @interface WinsonAnnotationTwo {
        String value() default "two";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
    @WinsonAnnotationTwo("runtime-two")
    public @interface WinsonAnnotationThree {
        String value() default "three";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
    public @interface Other{

    }


    public static void main(String[] args) {

        System.out.println("==== isAnnotationPresent ====");
        System.out.println(AnnotatedDemo.class.isAnnotationPresent(Other.class));
        System.out.println(AnnotatedDemo.class.isAnnotationPresent(WinsonAnnotationOne.class));
        System.out.println(AnnotatedDemo.class.isAnnotationPresent(WinsonAnnotationTwo.class));
        System.out.println(AnnotatedDemo.class.isAnnotationPresent(WinsonAnnotationThree.class));
        System.out.println("==== getAnnotation ===");
        System.out.println(AnnotatedDemo.class.getAnnotation(Other.class));
        System.out.println(AnnotatedDemo.class.getAnnotation(WinsonAnnotationOne.class));
        System.out.println(AnnotatedDemo.class.getAnnotation(WinsonAnnotationTwo.class));
        System.out.println(AnnotatedDemo.class.getAnnotation(WinsonAnnotationThree.class));
        System.out.println("==== getDeclaredAnnotation ===");
        System.out.println(AnnotatedDemo.class.getDeclaredAnnotation(Other.class));
        System.out.println(AnnotatedDemo.class.getDeclaredAnnotation(WinsonAnnotationOne.class));
        System.out.println(AnnotatedDemo.class.getDeclaredAnnotation(WinsonAnnotationTwo.class));
        System.out.println(AnnotatedDemo.class.getDeclaredAnnotation(WinsonAnnotationThree.class));
        System.out.println("==== getDeclaredAnnotationsByType ===");
        System.out.println(Arrays.stream(AnnotatedDemo.class.getDeclaredAnnotationsByType(Other.class)).collect(Collectors.toList()));
        System.out.println(Arrays.stream(AnnotatedDemo.class.getDeclaredAnnotationsByType(WinsonAnnotationOne.class)).collect(Collectors.toList()));
        System.out.println(Arrays.stream(AnnotatedDemo.class.getDeclaredAnnotationsByType(WinsonAnnotationTwo.class)).collect(Collectors.toList()));
        System.out.println(Arrays.stream(AnnotatedDemo.class.getDeclaredAnnotationsByType(WinsonAnnotationThree.class)).collect(Collectors.toList()));
        System.out.println("==== AnnotatedElementUtils.findMergedAnnotation ===");
        System.out.println(AnnotatedElementUtils.findMergedAnnotation(AnnotatedDemo.class, Other.class));
        System.out.println(AnnotatedElementUtils.findMergedAnnotation(AnnotatedDemo.class, WinsonAnnotationOne.class));
        System.out.println(AnnotatedElementUtils.findMergedAnnotation(AnnotatedDemo.class, WinsonAnnotationTwo.class));
        System.out.println(AnnotatedElementUtils.findMergedAnnotation(AnnotatedDemo.class, WinsonAnnotationThree.class));


    }

}
