package io.github.mikeiansky.spring.v6.overview.annotation.springbase;

import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mike ian
 * @date 2025/5/7
 * @desc
 **/
public class AliasForAnnoBaseDemo {

    @Target({ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface HelloOne {

        String sayOne() default "say-one-good";

    }

    @HelloOne(sayOne = "hello one on hello two annotation")
    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface HelloTwo {

        @AliasFor(annotation = HelloOne.class, value = "sayOne")
        String sayTwo() default "say-two-good";
    }

    @HelloTwo(
            sayTwo = "this is two one on one object"
    )
    public static class One {

    }

    public static void main(String[] args) {
        AnnotationMetadata annotationMetadata = AnnotationMetadata.introspect(One.class);
        MergedAnnotations mergedAnnotations = annotationMetadata.getAnnotations();
        MergedAnnotation<HelloOne> helloOne = mergedAnnotations.get(HelloOne.class);
        System.out.println(helloOne.getValue("sayOne"));

        MergedAnnotation<HelloTwo> helloTwo = mergedAnnotations.get(HelloTwo.class);
        System.out.println(helloTwo.getValue("sayTwo"));

    }

}
