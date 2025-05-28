package io.github.mikeiansky.spring.v6.overview.utils;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @author mike ian
 * @date 2025/5/28
 * @desc
 **/
public class ReflectionUtilsDemo {

    public static class Parent {

        public void parentMethod1() {
        }

        public void parentMethod2() {
        }

        private void parentMethod3() {
        }

        protected void parentMethod4() {
        }

        void parentMethod5() {
        }
    }

    public static class One extends Parent{

        public void method1() {
        }

        public void method2() {
        }

        private void method3() {
        }

        protected void method4() {
        }

        void method5() {
        }
    }

    public static void main(String[] args) {

        Method[] methods = ReflectionUtils.getAllDeclaredMethods(One.class);
        for (Method method : methods) {
            System.out.println("Method name: " + method.getName() + ", Modifiers: " + method.getModifiers() + ", Return type: " + method.getReturnType() + ", Parameter types: " + method.getParameterTypes().length);
            System.out.println("-----------------------------");
        }

    }

}
