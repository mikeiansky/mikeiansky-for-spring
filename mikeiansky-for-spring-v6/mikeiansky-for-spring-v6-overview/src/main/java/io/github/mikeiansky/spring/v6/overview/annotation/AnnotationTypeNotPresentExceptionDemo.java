package io.github.mikeiansky.spring.v6.overview.annotation;

import io.github.mikeiansky.spring.v6.overview.domain.User;
import io.github.mikeiansky.utils.CollKit;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.function.Function;

/**
 * @author mike ian
 * @date 2024/12/16
 * @desc
 **/
public class AnnotationTypeNotPresentExceptionDemo {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FatherAnnotation {

        Class<?> value();

    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MultiFatherAnnotation {

        Class<?>[] value();

    }

    @FatherAnnotation(CollKit.class)
    @MultiFatherAnnotation({CollKit.class, User.class})
//    @MultiFatherAnnotation(User.class)
    public static class One {

        public static void hello() {
            System.out.println("hello one");
        }

    }

    public static void main(String[] args) {
        System.out.println("start ... ");

        try {
            CollKit.toList(Collections.emptyList(), Function.identity());
        } catch (Throwable e) {
            e.printStackTrace();
        }

        One.hello();
        try {
            System.out.println(One.class.getAnnotation(FatherAnnotation.class).value());
        } catch (Exception e) {
            e.printStackTrace();
        }

        FatherAnnotation fatherAnnotation = AnnotatedElementUtils.findMergedAnnotation(One.class, FatherAnnotation.class);
        System.out.println("fatherAnnotation :: " + fatherAnnotation);
        MultiFatherAnnotation multiFatherAnnotation = AnnotatedElementUtils.findMergedAnnotation(One.class, MultiFatherAnnotation.class);
        System.out.println("multiFatherAnnotation :: " + multiFatherAnnotation);

        System.out.println("complete ... ");
    }

}
