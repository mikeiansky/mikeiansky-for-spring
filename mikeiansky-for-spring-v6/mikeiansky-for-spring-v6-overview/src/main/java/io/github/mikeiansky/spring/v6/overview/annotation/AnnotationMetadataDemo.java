package io.github.mikeiansky.spring.v6.overview.annotation;

import io.github.mikeiansky.spring.v6.overview.conditional.BaseConditional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
public class AnnotationMetadataDemo {

    @Configuration
    @Primary
    @Lazy
    public static class One {

        @Qualifier("tag-qualifier")
        @Value("tag-value")
        @Autowired
        private String tag;

        @Conditional(BaseConditional.class)
        @Qualifier("method-bean-qualifier")
        @AliasFor(value = "method-bean-alias")
        @Bean(initMethod = "toString")
        public String methodBean() {
            return "method - bean";
        }

    }

    public static void main(String[] args) {

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(AnnotationScanDemo.class);
//        context.refresh();

        AnnotationMetadata annotationMetadata = AnnotationMetadata.introspect(One.class);
        System.out.println(annotationMetadata);

        boolean hasConfiguration = annotationMetadata.getAnnotations().isPresent(Configuration.class);
        System.out.println("has configuration : " + hasConfiguration);

    }

}
