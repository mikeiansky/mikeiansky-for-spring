package io.github.mikeiansky.spring.v6.overview.annotation.springbase;

import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.annotation.RepeatableContainers;

import java.lang.annotation.*;

/**
 * @author mike ian
 * @date 2025/5/8
 * @desc
 **/
public class MergedAnnotationsBaseDemo {

    //    @Inherited
    @Target({ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface GrandFatherAnnotation {
        String hello() default "Hello";
    }

    //    @Inherited
    @GrandFatherAnnotation(hello = "hello father")
    @Target({ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FatherAnnotation {

//        @AliasFor(annotation = GrandFatherAnnotation.class, value = "hello")
        String good() default "Good";

    }

    @FatherAnnotation(good = "one good")
    public static class One {

    }

    public static class Two extends One {

    }

    public static void main(String[] args) {

        MergedAnnotations oneAnno = MergedAnnotations.from(One.class,
                MergedAnnotations.SearchStrategy.TYPE_HIERARCHY,
                RepeatableContainers.none());
        MergedAnnotation<FatherAnnotation> father = oneAnno.get(FatherAnnotation.class);
        System.out.println(father.asMap());
        System.out.println(father.getValue("good"));
        System.out.println(father.getValue("hello"));
        System.out.println("father.isPresent() : " + father.isPresent());
        System.out.println("father.isDirectlyPresent() : " + father.isDirectlyPresent());

        System.out.println("====== ");
        MergedAnnotation<GrandFatherAnnotation> grandFather = oneAnno.get(GrandFatherAnnotation.class);
        System.out.println(grandFather.asMap());
        System.out.println(grandFather.getValue("good"));
        System.out.println(grandFather.getValue("hello"));
        System.out.println("grandFather.isPresent() : " + grandFather.isPresent());
        System.out.println("grandFather.isDirectlyPresent() : " + grandFather.isDirectlyPresent());
        System.out.println(grandFather.getValue("hello"));

    }

}
