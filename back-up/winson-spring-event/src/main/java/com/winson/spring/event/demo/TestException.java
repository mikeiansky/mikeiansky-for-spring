package com.winson.spring.event.demo;

public class TestException {

    public static void testException1() throws Exception {
        System.out.println("test exception 1");
        testException2();
        System.out.println("test exception 1 end");
    }

    public static void testException2() throws Exception {
        System.out.println("test exception 2");
        testException3();
        throw new Exception("test exception 2");
    }

    public static void testException3() throws Exception {
        System.out.println("test exception 3");
        try {
            testException4();
        } catch (Exception e) {
            throw new Exception("test exception 3 inner", e);
        }
        throw new Exception("test exception 3");
    }

    public static void testException4() throws Exception {
        System.out.println("test exception 4");
        throw new Exception("test exception 4");
    }

    public static void main(String[] args) throws Exception {

        testException1();

    }

}
