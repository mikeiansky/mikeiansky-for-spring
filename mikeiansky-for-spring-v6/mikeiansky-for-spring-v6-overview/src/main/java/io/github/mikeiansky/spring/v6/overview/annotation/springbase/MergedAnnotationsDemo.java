package io.github.mikeiansky.spring.v6.overview.annotation.springbase;

import io.github.mikeiansky.spring.v6.overview.annotation.anno.Flag_01;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.annotation.RepeatableContainers;

import java.util.Optional;

/**
 * @author mike ian
 * @date 2025/5/1
 * @desc
 **/
public class MergedAnnotationsDemo {


    @Flag_01(hello = "change world")
    public static class One {

    }

    public static void main(String[] args) {
        MergedAnnotations oneMergedAnnotations = MergedAnnotations.from(One.class,
                MergedAnnotations.SearchStrategy.INHERITED_ANNOTATIONS,
                RepeatableContainers.none());

        MergedAnnotation<Flag_01> flag_01MergedAnnotation = oneMergedAnnotations.get(Flag_01.class);
        System.out.println("flag_01 merged annotation: " + flag_01MergedAnnotation);
        System.out.println("-------");
        Optional<Object> flag_01Hello = flag_01MergedAnnotation.getValue("hello");
        String flag_01HelloString = flag_01MergedAnnotation.getString("hello");
        System.out.println("flag_01Hello : " + flag_01Hello.get());
        System.out.println("flag_01HelloString : " + flag_01HelloString);
        oneMergedAnnotations.isDirectlyPresent(AnnotationMetadataDemo.AnnotationFlag_01.class.getName());

    }

}
