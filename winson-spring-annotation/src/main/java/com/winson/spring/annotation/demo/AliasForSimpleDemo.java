package com.winson.spring.annotation.demo;

import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;

import java.lang.annotation.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author winson
 * @date 2022/3/3
 **/
@AliasForSimpleDemo.Four
//@AliasForSimpleDemo.Three
public class AliasForSimpleDemo {

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Two {

        int twoAA() default 21;

        int twoBB() default 22;

        String twoName() default "this is two name";

        String twoZZ() default "twoZZ";


    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Two
    public @interface Three {

        int threeAA() default 31;

        int threeQQ() default 32;

        @AliasFor(annotation = Two.class, value = "twoAA")
        int threeXX() default 33;

        @AliasFor(annotation = Two.class, value = "twoAA")
        int threeYY() default 33;

        @AliasFor(annotation = Two.class, value = "twoName")
        String threeName() default "this is three name";

        String twoZZ() default "twoZZ ==> @@@@@ Three @@@@";
//        String twoZZ();

    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Three
    public @interface Four {

        @AliasFor(annotation = Two.class, value = "twoAA")
        int fourXX() default 44;

        @AliasFor(annotation = Two.class, value = "twoZZ")
        String twoZZ() default "twoZZ ==> @@@@@ Three @@@@";

    }

    public static void main(String[] args) {

        MergedAnnotations mergedAnnotations = MergedAnnotations.from(AliasForSimpleDemo.class,
                MergedAnnotations.SearchStrategy.TYPE_HIERARCHY);

        System.out.println(mergedAnnotations.stream()
                .map(annotationMergedAnnotation -> {
                    System.out.println("aaaa---> 1");
                    return annotationMergedAnnotation;
                })
                .map(annotationMergedAnnotation -> {
                    System.out.println("bbbb---> 2");
                    return annotationMergedAnnotation;
                })
                .collect(Collectors.toList()));

//        // --
//        MergedAnnotation<Three> threeMergedAnnotation = mergedAnnotations.get(Three.class);
//        // will go to four
//        System.out.println(threeMergedAnnotation.getValue("threeXX").get());

        MergedAnnotation<Two> twoMergedAnnotation = mergedAnnotations.get(Two.class);

        System.out.println(twoMergedAnnotation.getValue("twoName").get());
        System.out.println(twoMergedAnnotation.getValue("twoAA").get());
        System.out.println(twoMergedAnnotation.getValue("twoZZ").get());

    }

}
