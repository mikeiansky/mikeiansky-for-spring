package io.github.mikeiansky.spring.v6.overview.annotation.anno;

import java.lang.annotation.*;

/**
 * @author mike ian
 * @date 2025/5/1
 * @desc
 **/
public class BaseAnnoDemo {

    @Inherited
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AnnoFather {

    }

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

    }

//    @Inherited
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AnnoSon2Repeatable {
        AnnoSon2[] value();
    }


    @AnnoInherited
    @AnnoSon
//    @AnnoSon
    @AnnoSon2
    @AnnoSon2
    public static class One {

    }

    public static class Two extends One {

    }

    public static void main(String[] args) {
        Class<One> oneClazz = One.class;
        AnnoInherited annoInherited = oneClazz.getAnnotation(AnnoInherited.class);
        System.out.println("one::annoInherited : " + annoInherited);
        AnnoFather annoFather = oneClazz.getAnnotation(AnnoFather.class);
        System.out.println("one::annoFather : " + annoFather);
        AnnoSon annoSon = oneClazz.getAnnotation(AnnoSon.class);
        System.out.println("one::annoSon : " + annoSon);
        AnnoSon2 annoSon2 = oneClazz.getAnnotation(AnnoSon2.class);
        System.out.println("one::annoSon2 : " + annoSon2);
        Class<Two> twoClazz = Two.class;
        AnnoInherited twoAnnoInherited = twoClazz.getAnnotation(AnnoInherited.class);
        System.out.println("two::twoAnnoInherited : " + twoAnnoInherited);
        AnnoFather twoAnnoFather = twoClazz.getAnnotation(AnnoFather.class);
        System.out.println("two::annoFather : " + twoAnnoFather);
        AnnoSon twoAnnoSon = twoClazz.getAnnotation(AnnoSon.class);
        System.out.println("two::annoSon : " + twoAnnoSon);
        AnnoSon2 twoAnnoSon2 = twoClazz.getAnnotation(AnnoSon2.class);
        System.out.println("two::annoSon2 : " + twoAnnoSon2);
    }

}
