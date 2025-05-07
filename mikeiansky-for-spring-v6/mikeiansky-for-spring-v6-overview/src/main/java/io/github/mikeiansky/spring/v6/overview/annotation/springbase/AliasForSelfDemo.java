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
public class AliasForSelfDemo {

    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface HelloTwo {

        String first() default "hello-second";


        @AliasFor("first")
        String second() default "hello-second";

    }

    @HelloTwo(second = "change second by one")
    public static class One {

    }

    public static class Two {

    }

    public static void main(String[] args) {
        AnnotationMetadata metadata = AnnotationMetadata.introspect(One.class);

        MergedAnnotations annotations = metadata.getAnnotations();
        MergedAnnotation<HelloTwo> annotation = annotations.get(HelloTwo.class);
        Object firstValue = annotation.getValue("first");
        System.out.println(firstValue);

    }

}
