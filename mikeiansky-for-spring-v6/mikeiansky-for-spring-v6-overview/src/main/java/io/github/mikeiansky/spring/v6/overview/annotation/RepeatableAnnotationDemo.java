package io.github.mikeiansky.spring.v6.overview.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.*;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author mike ian
 * @date 2024/12/19
 * @desc
 **/
public class RepeatableAnnotationDemo {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SonAnnotation {
        String hello() default "hello-son";
    }

    @SonAnnotation(hello = "hello-one")
    @ComponentScan(value = "hello.scan1")
    @ComponentScan(value = "hello.scan2")
    public static class One {

    }

    public static void main(String[] args) {

        SonAnnotation sonAnnotation = AnnotatedElementUtils.findMergedAnnotation(One.class, SonAnnotation.class);
        System.out.println(sonAnnotation);
        System.out.println(sonAnnotation.hello());
        Set<ComponentScan> componentScans = AnnotatedElementUtils.findMergedRepeatableAnnotations(One.class, ComponentScan.class);
        for (ComponentScan componentScan : componentScans) {
            System.out.println(componentScan);
            System.out.println(Arrays.stream(componentScan.value()).collect(Collectors.joining(",")));
        }

    }

}
