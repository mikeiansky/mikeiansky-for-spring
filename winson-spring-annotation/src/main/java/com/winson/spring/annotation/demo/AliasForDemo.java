package com.winson.spring.annotation.demo;

/**
 * @author winson
 * @date 2022/3/2
 **/

import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;
import java.util.Map;

@AliasForDemo.Three(aliasForOneTopName = "change-one-alias-for-demo")
public class AliasForDemo {

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE})
    public @interface One {

        String topName() default "topName";

        String oneName() default "one-name";

        int oneAge() default 1;

        String oneOtherName() default "one-other-name";

        @AliasFor("oneAge")
        int otherOneAge() default 1;

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE})
    @One
    public @interface Two {

//        @AliasFor("twoOtherName")
        String twoName() default "two-together-name";

        int twoAge() default 2;

        @AliasFor(annotation = One.class, attribute = "oneOtherName")
        String twoOtherName() default "two-together-name";

        @AliasFor(annotation = One.class, attribute = "topName")
        String twoTopName() default "two-top-name";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE})
    @Two(twoOtherName = "change-by-two-head-at-three")
    public @interface Three {

//        @AliasFor(attribute = "threeOtherName")
        String threeName() default "three-together-name";

//        @AliasFor(value = "threeName")
        String threeOtherName() default "three-together-name";

        int threeAge() default 3;

        @AliasFor(annotation = One.class, value = "oneAge")
        int threeForOneAge() default 31;

//        @AliasFor(annotation = Two.class, attribute = "twoName")
        @AliasFor(annotation = Two.class, value = "twoName")
//        @AliasFor(annotation = One.class, attribute = "oneName")
//        @AliasFor(annotation = One.class, value = "oneName")
        String aliasForOtherName() default "three-name";
//        String aliasForOneName() default "aliasForOneName";

        @AliasFor(annotation = One.class, value = "topName")
        String aliasForOneTopName() default "three-top-name";

    }

    public static void main(String[] args) {
        // MirrorSet 是出现多个的情况 比如 @one 的同一个属性， 被@two注解，也被@three注解，就会出现一个方法被多次AliasFor的情况
        MergedAnnotations annotations = MergedAnnotations.from(AliasForDemo.class, MergedAnnotations.SearchStrategy.TYPE_HIERARCHY);
        System.out.println("=== one annotation ===");
        MergedAnnotation<One> oneAnnotation = annotations.get(One.class);
        System.out.println(oneAnnotation.getValue("topName").get());
        System.out.println(oneAnnotation.getValue("oneName").get());
        System.out.println(oneAnnotation.getValue("oneAge").get());
        System.out.println(oneAnnotation.getValue("oneOtherName").get());
        Map<String,Object> oneAttributeMap = oneAnnotation.asMap();
        System.out.println(oneAttributeMap);

//        System.out.println("=== two annotation ===");

//        HelloConfig helloConfig = new HelloConfig();


//        System.out.println("=== two annotation ===");

        Date date = new Date();
//        oneAnnotation = annotations.get(One.class);

        System.out.println("=== two annotation ===");
        MergedAnnotation<Two> twoAnnotation = annotations.get(Two.class);
        System.out.println(twoAnnotation.getValue("twoName").get());
        System.out.println(twoAnnotation.getValue("twoAge").get());
        System.out.println(twoAnnotation.getValue("twoOtherName").get());
        Map<String,Object> twoAttributeMap = twoAnnotation.asMap();
        System.out.println(twoAttributeMap);

        System.out.println("=== three annotation ===");
        MergedAnnotation<Three> threeAnnotation = annotations.get(Three.class);
        System.out.println(threeAnnotation.getValue("threeName").get());
        System.out.println(threeAnnotation.getValue("threeAge").get());
        System.out.println(threeAnnotation.getValue("threeOtherName").get());
        System.out.println(threeAnnotation.getValue("aliasForOneTopName").get());
        Map<String,Object> threeAttributeMap = threeAnnotation.asMap();
        System.out.println(threeAttributeMap);
    }

}
