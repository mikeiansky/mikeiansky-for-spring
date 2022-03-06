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
        System.out.println(resolvableType.resolveGeneric());
        System.out.println(resolvableType.getSuperType().getGenerics()[0]);
//        System.out.println(resolvableType.getSuperType().getGenerics()[0].getGenerics()[0].getSource());
        System.out.println("resolveGeneric : " + resolvableType.getSuperType().resolveGeneric());
        System.out.println("resolveGeneric 0 : " + resolvableType.getSuperType().resolveGeneric(0).getClass().getTypeParameters());
        System.out.println("resolveGeneric 1 : " + resolvableType.getSuperType().resolveGeneric(1));
        System.out.println("resolveGeneric 2 : " + resolvableType.getSuperType().resolveGeneric(3));
        System.out.println(resolvableType.getSuperType().getSuperType());
        System.out.println(resolvableType.getSuperType().getSuperType().resolveGeneric(0));
        System.out.println(resolvableType.getSuperType().getSuperType().getSuperType());
        System.out.println(resolvableType.getSuperType().getSuperType().getSuperType().resolveGeneric(0));
        System.out.println(resolvableType.getSuperType().getSuperType().getSuperType().getSuperType());
        System.out.println(resolvableType.getSuperType().getSuperType().getSuperType().getSuperType().resolveGeneric(0));
        System.out.println("========== collection ==========");
        System.out.println(resolvableType.asMap());
        System.out.println(resolvableType.as(Flag.class));
        System.out.println(resolvableType.asCollection());
        System.out.println(resolvableType.asCollection().resolve());
        System.out.println(resolvableType.asCollection().resolveGeneric(0));
        System.out.println(resolvableType.resolve());
        System.out.println(resolvableType.getSuperType().resolveGeneric(0));
        System.out.println("========== interfaces ==========");
        System.out.println(resolvableType.getInterfaces().length);
        Arrays.stream(resolvableType.getInterfaces()).forEach(System.out::println);
        System.out.println(resolvableType.getGenerics().length);
        System.out.println(resolvableType.getSuperType().getInterfaces().length);

    }

}
