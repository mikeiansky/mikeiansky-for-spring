package com.winson.spring.annotation.demo;

import org.springframework.core.annotation.AnnotationFilter;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.annotation.RepeatableContainers;

import java.lang.annotation.*;

/**
 * @author winson
 * @date 2022/3/5
 **/
@RepeatableAnnotationDemo.One(testOne = "first - one")
@RepeatableAnnotationDemo.One(testOne = "second - one")
public class RepeatableAnnotationDemo {

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @Repeatable(MoreOne.class)
    public @interface One {
        String testOne() default "this is one";
    }

    @Target({ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Other {

    }

    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MoreOne {
        One[] value();
    }

    public static void main(String[] args) {

//        RepeatableContainers containers = RepeatableContainers.standardRepeatables();
//        RepeatableContainers containers = RepeatableContainers.of(
//            One.class, MoreOne.class
//        );
        RepeatableContainers containers = RepeatableContainers.none();
//        containers.and(null, Other.class);
        containers = containers.and(null, One.class);

        MergedAnnotations mergedAnnotations = MergedAnnotations.from(RepeatableAnnotationDemo.class,
                MergedAnnotations.SearchStrategy.TYPE_HIERARCHY,
                containers, AnnotationFilter.PLAIN);

        MergedAnnotation<One> oneMergedAnnotation1 = mergedAnnotations.get(One.class);
        System.out.println(oneMergedAnnotation1);
        System.out.println(oneMergedAnnotation1.getValue("testOne"));
        MergedAnnotation<One> oneMergedAnnotation2 = mergedAnnotations.get(One.class);
        System.out.println(oneMergedAnnotation2);
        System.out.println(oneMergedAnnotation2.getValue("testOne"));
//        MergedAnnotation<One> oneMergedAnnotation3 = mergedAnnotations.get(One.class);
//        System.out.println(oneMergedAnnotation3);
//        MergedAnnotation<One> oneMergedAnnotation4 = mergedAnnotations.get(One.class);
//        System.out.println(oneMergedAnnotation4);
    }

}
