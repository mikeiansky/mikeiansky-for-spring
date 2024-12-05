package com.winson.spring.generic;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.MergedAnnotations;

import java.lang.annotation.*;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author winson
 * @date 2021/10/5
 **/
@AnnotatedDemo.WinsonAnnotationThree("runtime-three")
@AnnotatedDemo.Other
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
    @Inherited
    @WinsonAnnotationTwo("runtime-two")
    public @interface WinsonAnnotationThree {
        String value() default "three";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
    public @interface Other{

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
    public @interface MotherAnnotation {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
    public @interface FatherAnnotation{

    }

    @FatherAnnotation
    @MotherAnnotation
    public static class Person {

    }

    @AnnotatedDemo.WinsonAnnotationThree("define@student")
    public static class Student extends Person{

    }


    public static void main(String[] args) {

        System.out.println("==== isAnnotationPresent ====");
        System.out.println(Student.class.isAnnotationPresent(Other.class));
        System.out.println(Student.class.isAnnotationPresent(FatherAnnotation.class));
        System.out.println(Student.class.isAnnotationPresent(MotherAnnotation.class));
        System.out.println(Student.class.isAnnotationPresent(WinsonAnnotationOne.class));
        System.out.println(Student.class.isAnnotationPresent(WinsonAnnotationTwo.class));
        System.out.println(Student.class.isAnnotationPresent(WinsonAnnotationThree.class));
        System.out.println("==== getAnnotation ===");
        System.out.println(Student.class.getAnnotation(Other.class));
        System.out.println(Student.class.getAnnotation(FatherAnnotation.class));
        System.out.println(Student.class.getAnnotation(MotherAnnotation.class));
        System.out.println(Student.class.getAnnotation(WinsonAnnotationOne.class));
        System.out.println(Student.class.getAnnotation(WinsonAnnotationTwo.class));
        System.out.println(Student.class.getAnnotation(WinsonAnnotationThree.class));
        System.out.println("==== getDeclaredAnnotation ===");
        System.out.println(Student.class.getDeclaredAnnotation(Other.class));
        System.out.println(Student.class.getDeclaredAnnotation(FatherAnnotation.class));
        System.out.println(Student.class.getDeclaredAnnotation(MotherAnnotation.class));
        System.out.println(Student.class.getDeclaredAnnotation(WinsonAnnotationOne.class));
        System.out.println(Student.class.getDeclaredAnnotation(WinsonAnnotationTwo.class));
        System.out.println(Student.class.getDeclaredAnnotation(WinsonAnnotationThree.class));
        System.out.println("==== getDeclaredAnnotationsByType ===");
        System.out.println(Arrays.stream(Student.class.getDeclaredAnnotationsByType(Other.class)).collect(Collectors.toList()));
        System.out.println(Arrays.stream(Student.class.getDeclaredAnnotationsByType(FatherAnnotation.class)).collect(Collectors.toList()));
        System.out.println(Arrays.stream(Student.class.getDeclaredAnnotationsByType(MotherAnnotation.class)).collect(Collectors.toList()));
        System.out.println(Arrays.stream(Student.class.getDeclaredAnnotationsByType(WinsonAnnotationOne.class)).collect(Collectors.toList()));
        System.out.println(Arrays.stream(Student.class.getDeclaredAnnotationsByType(WinsonAnnotationTwo.class)).collect(Collectors.toList()));
        System.out.println(Arrays.stream(Student.class.getDeclaredAnnotationsByType(WinsonAnnotationThree.class)).collect(Collectors.toList()));
        System.out.println("==== AnnotatedElementUtils.findMergedAnnotation ===");
        System.out.println(AnnotatedElementUtils.findMergedAnnotation(AnnotatedDemo.class, Other.class));
        System.out.println(AnnotatedElementUtils.findMergedAnnotation(AnnotatedDemo.class, FatherAnnotation.class));
        System.out.println(AnnotatedElementUtils.findMergedAnnotation(AnnotatedDemo.class, MotherAnnotation.class));
        System.out.println(AnnotatedElementUtils.findMergedAnnotation(AnnotatedDemo.class, WinsonAnnotationOne.class));
        System.out.println(AnnotatedElementUtils.findMergedAnnotation(AnnotatedDemo.class, WinsonAnnotationTwo.class));
        System.out.println(AnnotatedElementUtils.findMergedAnnotation(AnnotatedDemo.class, WinsonAnnotationThree.class));
        System.out.println("==== AnnotatedElementUtils.findMergedAnnotation for Student ===");
//        System.out.println(AnnotatedElementUtils.findMergedAnnotation(Student.class, Other.class));
        // search_strategy is DIRECT
        System.out.println(MergedAnnotations.from(Student.class, MergedAnnotations.SearchStrategy.DIRECT)
                .get(FatherAnnotation.class));
        // search_strategy is INHERITED_ANNOTATIONS
        System.out.println(MergedAnnotations.from(Student.class, MergedAnnotations.SearchStrategy.INHERITED_ANNOTATIONS)
                .get(FatherAnnotation.class));
        // search_strategy is INHERITED_ANNOTATIONS
        System.out.println(MergedAnnotations.from(Student.class, MergedAnnotations.SearchStrategy.INHERITED_ANNOTATIONS)
                .get(MotherAnnotation.class));
        // search_strategy is SUPERCLASS
        System.out.println(MergedAnnotations.from(Student.class, MergedAnnotations.SearchStrategy.SUPERCLASS)
                .get(FatherAnnotation.class));
        // search_strategy is TYPE_HIERARCHY
        System.out.println(MergedAnnotations.from(Student.class, MergedAnnotations.SearchStrategy.TYPE_HIERARCHY)
                .get(FatherAnnotation.class));
        // search_strategy is TYPE_HIERARCHY_AND_ENCLOSING_CLASSES
        System.out.println(MergedAnnotations.from(Student.class, MergedAnnotations.SearchStrategy.TYPE_HIERARCHY_AND_ENCLOSING_CLASSES)
                .get(Other.class));

        System.out.println(AnnotationUtils.findAnnotationDeclaringClass(WinsonAnnotationTwo.class, Student.class));
        System.out.println(AnnotatedElementUtils.findMergedAnnotation(Student.class, FatherAnnotation.class));
        System.out.println(AnnotatedElementUtils.findMergedAnnotation(Student.class, MotherAnnotation.class));
        System.out.println(AnnotatedElementUtils.findMergedAnnotation(Student.class, WinsonAnnotationOne.class));
        System.out.println(AnnotatedElementUtils.findMergedAnnotation(Student.class, WinsonAnnotationTwo.class));
        System.out.println(AnnotatedElementUtils.findMergedAnnotation(Student.class, WinsonAnnotationThree.class));


    }

}
