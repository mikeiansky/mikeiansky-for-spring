package io.github.mikeiansky.spring.v6.overview.annotation.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mike ian
 * @date 2025/5/1
 * @desc
 **/
public class ClazzGenericDemo {

    @HelloAnno
    public static class One {

    }

    public static class Two {

    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface HelloAnno {

    }

    public static <A> Class<A> hello(Class<A> clazz, A a) {
        System.out.println("hello clazz : " + clazz + " , a : " + a);
        return (Class<A>)a.getClass();
    }

    public static void main(String[] args) {
        One one = new One();
        Two two = new Two();
        Class<One> oneClass = hello(One.class, one);
        System.out.println("hello oneClass : " + oneClass);

        HelloAnno helloAnno = oneClass.getAnnotation(HelloAnno.class);
        System.out.println("helloAnno : " + helloAnno);

        Class<HelloAnno> helloAnnoClass = hello(HelloAnno.class, helloAnno);
        System.out.println("helloAnnoClass : " + helloAnnoClass);

        Class<One> oneClazz = One.class;
        Class oneClazz2 = One.class.getClass();
        Class<One> oneClazz3 = One.class;
        System.out.println(oneClazz);
        System.out.println(oneClazz.getName());
        System.out.println(oneClazz.getName().equals(oneClass));
        System.out.println(oneClazz3);
        System.out.println(oneClazz == oneClazz3);


    }

}
