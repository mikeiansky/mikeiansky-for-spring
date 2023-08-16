package com.winson.spring.utils;

import com.winson.spring.overview.domain.User;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author winson
 * @date 2021/10/9
 **/
public class ReflectionMethodUtilsDemo {

    public static void main(String[] args) {

//        Method[] methods = ReflectionUtils.getDeclaredMethods(User.class);
//        for (Method method : methods) {
//            System.out.println(method.getName());
//        }
        System.out.println("============= doWithMethods =============");
        ReflectionUtils.doWithMethods(User.class, new ReflectionUtils.MethodCallback() {
            @Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                System.out.println(method.getName());
            }
        });
//        ReflectionUtils.doWithLocalMethods(User.class, null);

        System.out.println("============= doWithFields =============");
        ReflectionUtils.doWithFields(User.class, new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                System.out.println(field.getName());
            }
        });

        System.out.println("============= doWithLocalFields =============");
        ReflectionUtils.doWithLocalFields(User.class, new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                System.out.println(field.getName());
            }
        });

        ReflectionUtils.clearCache();

    }

}
