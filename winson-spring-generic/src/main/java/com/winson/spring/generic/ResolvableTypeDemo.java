package com.winson.spring.generic;

import org.springframework.core.ResolvableType;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

/**
 * @author winson
 * @date 2021/10/4
 **/
public class ResolvableTypeDemo {

    public static void main(String[] args) {

//        System.out.println(ResolvableType.forClass(Object.class).resolve());

//        ResolvableType resolvableType = ResolvableType.forClass(StringList.class);
        ResolvableType resolvableType = ResolvableType.forClass(WinsonMap.class);
        System.out.println("========== Super info ==========");
        System.out.println("toString():" + resolvableType.toString());
        System.out.println("instanceof Class : " + (resolvableType.getType() instanceof Class));
        System.out.println("resolveGeneric : " + resolvableType.resolveGeneric());
        System.out.println("superType generic : " + resolvableType.getSuperType().getGenerics()[0]);
//        System.out.println(resolvableType.getSuperType().getGenerics()[0].getGenerics()[0].getSource());
        System.out.println("superType resolveGeneric : " + resolvableType.getSuperType().resolveGeneric());
        System.out.println("resolveGeneric 0 class : " + resolvableType.getSuperType().resolveGeneric(0).getClass());
        System.out.println("resolveGeneric 0 class : " + resolvableType.getSuperType().resolveGeneric(0, 1));
        System.out.println("resolveGeneric 0 class type parameter : " + resolvableType.getSuperType().resolveGeneric(0).getClass().getTypeParameters()[0]);
        System.out.println("resolveGeneric 0,1,2,3 : " + resolvableType.getSuperType().resolveGeneric(0));
        System.out.println("resolveGeneric 0 : " + resolvableType.getSuperType().resolveGeneric(0, 1, 2, 3));
        System.out.println("resolveGeneric 1 : " + resolvableType.getSuperType().resolveGeneric(1));
        System.out.println("resolveGeneric 2 : " + resolvableType.getSuperType().resolveGeneric(2));
        System.out.println("resolveGeneric 3 : " + resolvableType.getSuperType().resolveGeneric(3));
        System.out.println("superType : " + resolvableType.getSuperType());
        System.out.println("superType interfaces : " + resolvableType.getSuperType().getInterfaces());
        System.out.println("superType , superType : " + resolvableType.getSuperType().getSuperType());
        System.out.println("superType , superType resolveGeneric 0 : " + resolvableType.getSuperType().getSuperType().resolveGeneric(0));
        System.out.println("superType , superType , superType : " + resolvableType.getSuperType().getSuperType().getSuperType());
        System.out.println("superType , superType , superType , resolveGeneric : " + resolvableType.getSuperType().getSuperType().getSuperType().resolveGeneric(0));
        System.out.println("superType , superType , superType , superType : " + resolvableType.getSuperType().getSuperType().getSuperType().getSuperType());
        System.out.println("superType , superType , superType , superType , resolveGeneric : " + resolvableType.getSuperType().getSuperType().getSuperType().getSuperType().resolveGeneric(0));
        System.out.println("========== collection ==========");
        System.out.println("asMap(): " + resolvableType.asMap());
        System.out.println("asSelf(): " + resolvableType.as(WinsonMap.class));
        System.out.println("as(Flag.class): " + resolvableType.as(Flag.class));
        System.out.println("asCollection(): " + resolvableType.asCollection());
        System.out.println("asCollection().resolve(): " + resolvableType.asCollection().resolve());
        System.out.println("asCollection().resolveGeneric(0): " + resolvableType.asCollection().resolveGeneric(0));
        System.out.println("resolve(): " + resolvableType.resolve());
        System.out.println("getSuperType().resolveGeneric(0): " + resolvableType.getSuperType().resolveGeneric(0));
        System.out.println("========== interfaces ==========");
        System.out.println(resolvableType.getInterfaces().length);
        Arrays.stream(resolvableType.getInterfaces()).forEach(System.out::println);
        System.out.println(resolvableType.getGenerics().length);
        System.out.println(resolvableType.getSuperType().getInterfaces().length);

    }

}
