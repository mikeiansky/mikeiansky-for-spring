package com.winson.spring.annotation.demo;

import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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

        int twoZZ() default 23;


    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Two
    public @interface Three {

        int threeAA() default 31;

        int threeQQ() default 32;

        int threeXX() default 33;

        int threeYY() default 34;

        @AliasFor(annotation = Two.class, value = "twoName")
        String threeName() default "this is three name";

    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Three
    public @interface Four {

    }

    public static void main(String[] args) {

        MergedAnnotations mergedAnnotations = MergedAnnotations.from(AliasForSimpleDemo.class,
                MergedAnnotations.SearchStrategy.TYPE_HIERARCHY);

        MergedAnnotation<Two> twoMergedAnnotation = mergedAnnotations.get(Two.class);

        System.out.println(twoMergedAnnotation.getValue("twoName").get());

    }

}
