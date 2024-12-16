package io.github.mikeiansky.spring.v6.overview.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
public class AliasForAnnotatedElementUtilsDemo {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FatherAnnotation {

        String helloFather() default "hello-father";

    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @FatherAnnotation(helloFather = "hell-father-son")   // 这里必须要做
    public @interface SonAnnotation {

        @AliasFor(annotation = FatherAnnotation.class, value = "helloFather")
        String helloSon() default "hello-son";

//        @AliasFor(annotation = FatherAnnotation.class, value = "helloFather")
//        String normalSon() default "normal-son";

    }

    @SonAnnotation(helloSon = "hello-son-one")
    public static class One {

    }

    public static void main(String[] args) {
        // alias 的时候 创建了一个代理， 在代理中进行处理，并且做了缓存
        FatherAnnotation fatherAnnotation = AnnotatedElementUtils.findMergedAnnotation(One.class, FatherAnnotation.class);
        // 这里是被代理了
        String helloFather = fatherAnnotation.helloFather();
        System.out.println("helloFather: " + helloFather);
        System.out.println("fatherAnnotation :: " + fatherAnnotation);
        SonAnnotation sonAnnotation = AnnotatedElementUtils.findMergedAnnotation(One.class, SonAnnotation.class);
        sonAnnotation.helloSon();
//        sonAnnotation.normalSon();
        System.out.println("sonAnnotation :: " + sonAnnotation);
    }

}
