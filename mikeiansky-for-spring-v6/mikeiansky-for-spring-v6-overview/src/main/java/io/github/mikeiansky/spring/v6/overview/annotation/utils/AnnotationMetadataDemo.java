package io.github.mikeiansky.spring.v6.overview.annotation.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author mike ian
 * @date 2025/5/9
 * @desc
 **/
public class AnnotationMetadataDemo {

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FatherAnnotation {

        String help() default "help father";

        Class<? extends Collection> collection() default List.class;

    }

    @FatherAnnotation(
            collection = Set.class
    )
    @Configuration(
            proxyBeanMethods = false
    )
    public static class One {

    }

    public static void main(String[] args) {

        AnnotationMetadata metadata = AnnotationMetadata.introspect(One.class);
        MultiValueMap<String, Object> attributes = metadata.getAllAnnotationAttributes(
                FatherAnnotation.class.getName(),
                true
        );
        for (Object attribute : attributes.keySet()) {
            System.out.println("attribute: " + attribute);
            Object value = attributes.get(attribute);
            if (value instanceof Collection<?> cv) {
                for (Object o : cv) {
                    System.out.println(o.getClass() + ", o : " + o);
                }
            }
        }

    }

}
