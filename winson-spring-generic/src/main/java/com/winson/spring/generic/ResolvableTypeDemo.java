package com.winson.spring.generic;

import org.springframework.core.ResolvableType;

import java.util.Arrays;

/**
 * @author winson
 * @date 2021/10/4
 **/
public class ResolvableTypeDemo {

    public static void main(String[] args) {

//        System.out.println(ResolvableType.forClass(Object.class).resolve());

        ResolvableType resolvableType = ResolvableType.forClass(StringList.class);
        System.out.println(resolvableType.getSuperType());
        System.out.println(resolvableType.getSuperType().resolve());
        System.out.println(resolvableType.getSuperType().resolveGeneric(0));
        System.out.println(resolvableType.getSuperType().getSuperType());
        System.out.println(resolvableType.getSuperType().getSuperType().resolveGeneric(0));
        System.out.println(resolvableType.getSuperType().getSuperType().getSuperType());
        System.out.println(resolvableType.getSuperType().getSuperType().getSuperType().resolveGeneric(0));
        System.out.println(resolvableType.getSuperType().getSuperType().getSuperType().getSuperType());
        System.out.println(resolvableType.getSuperType().getSuperType().getSuperType().getSuperType().resolveGeneric(0));
        System.out.println(resolvableType.asMap());
        System.out.println(resolvableType.asCollection());
        System.out.println(resolvableType.asCollection().resolve());
        System.out.println(resolvableType.asCollection().resolveGeneric(0));
        System.out.println(resolvableType.resolve());
        System.out.println(resolvableType.getSuperType().resolveGeneric(0));
        System.out.println("get interfaces ===");
        Arrays.stream(resolvableType.getInterfaces()).forEach(System.out::println);
        System.out.println(resolvableType.getGenerics().length);
        System.out.println(resolvableType.getSuperType().getInterfaces().length);

    }

}
