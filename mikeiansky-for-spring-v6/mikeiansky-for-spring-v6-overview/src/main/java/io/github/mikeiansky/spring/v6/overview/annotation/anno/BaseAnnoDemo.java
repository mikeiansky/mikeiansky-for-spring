package io.github.mikeiansky.spring.v6.overview.annotation.anno;

import java.lang.annotation.*;

/**
 * @author mike ian
 * @date 2025/5/1
 * @desc
 **/
public class BaseAnnoDemo {

//    @Inherited
    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface God {

    }

    @Inherited
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AnnoFather {

    }

    @God
    @Inherited
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AnnoInherited {

    }

    @AnnoFather
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AnnoSon {

    }

    @Repeatable(AnnoSon2Repeatable.class)
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AnnoSon2 {
        String value() default "";
    }

//    @Inherited
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AnnoSon2Repeatable {
        AnnoSon2[] value();
    }

    @God
    @AnnoInherited
    @AnnoSon
//    @AnnoSon
    @AnnoSon2("one-001")
    @AnnoSon2("one-002")
    public static class One {

    }

//    @God
//    @AnnoInherited
    public static class Two extends One {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<One> oneClazz = One.class;
        AnnoInherited annoInherited = oneClazz.getAnnotation(AnnoInherited.class);
        System.out.println("one::annoInherited : " + annoInherited);
        AnnoFather annoFather = oneClazz.getAnnotation(AnnoFather.class);
        System.out.println("one::annoFather : " + annoFather);
        AnnoSon annoSon = oneClazz.getAnnotation(AnnoSon.class);
        System.out.println("one::annoSon : " + annoSon);
        AnnoSon2 annoSon2 = oneClazz.getAnnotation(AnnoSon2.class);
        System.out.println("one::annoSon2 : " + annoSon2);
        Repeatable annoRepeatable = oneClazz.getAnnotation(Repeatable.class);
        System.out.println("one::annoRepeatable : " + annoRepeatable);
        AnnoSon2Repeatable annoSon2Repeatable = oneClazz.getAnnotation(AnnoSon2Repeatable.class);
        System.out.println("one::annoSon2Repeatable : " + annoSon2Repeatable);
        Class<?> componentType = AnnoSon2Repeatable.class.getMethod("value").getReturnType().getComponentType();
        System.out.println(componentType);
        System.out.println(Annotation.class.isAssignableFrom(componentType));
        System.out.println(componentType.isAnnotationPresent(Repeatable.class));
        Class a2c = AnnoSon2.class;
        System.out.println(a2c);
        System.out.println(a2c.getComponentType());
        System.out.println(Annotation.class.isAssignableFrom(a2c));
        System.out.println(a2c.isAnnotationPresent(Repeatable.class));
        for (AnnoSon2 son2 : annoSon2Repeatable.value()) {
            System.out.println(son2);
        }
        System.out.println("======= for each one ========= ");
        for (Annotation annotation : oneClazz.getAnnotations()) {
            System.out.println(annotation);
        }
        System.out.println("=============== two ==============");
        Class<Two> twoClazz = Two.class;
        AnnoInherited twoAnnoInherited = twoClazz.getAnnotation(AnnoInherited.class);
        System.out.println("two::twoAnnoInherited : " + twoAnnoInherited);
        AnnoFather twoAnnoFather = twoClazz.getAnnotation(AnnoFather.class);
        System.out.println("two::annoFather : " + twoAnnoFather);
        AnnoSon twoAnnoSon = twoClazz.getAnnotation(AnnoSon.class);
        System.out.println("two::annoSon : " + twoAnnoSon);
        AnnoSon2 twoAnnoSon2 = twoClazz.getAnnotation(AnnoSon2.class);
        System.out.println("two::annoSon2 : " + twoAnnoSon2);
        God twoGod = twoClazz.getAnnotation(God.class);
        System.out.println("two::god : " + twoGod);
    }

}
