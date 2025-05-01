package io.github.mikeiansky.spring.v6.overview.jdk.base.reflect;

/**
 * @author mike ian
 * @date 2025/5/1
 * @desc
 **/
public class ClazzReflectDemo {

    public static class One {

        public static class InnerOne {

        }

        public class InnerTwo {

        }

    }

    public static void main(String[] args) {
        One one = new One();
        System.out.println("one : " + one);
        One.InnerOne innerOne = new One.InnerOne();
        System.out.println("innerOne : " + innerOne);
        One.InnerTwo innerTwo = one.new InnerTwo();
        System.out.println("innerTwo : " + innerTwo);
        System.out.println("==========");
        Class<One> oneClazz = One.class;
        System.out.println("oneClazz.getEnclosingClass() : " + oneClazz.getEnclosingClass());
        Class<One.InnerOne> innerOneClazz = One.InnerOne.class;
        System.out.println("innerOneClazz.getEnclosingClass() : " + innerOneClazz.getEnclosingClass());
        System.out.println("innerOneClazz.getEnclosingMethod() : " + innerOneClazz.getEnclosingMethod());
        System.out.println("innerOneClazz.getEnclosingConstructor() : " + innerOneClazz.getEnclosingConstructor());
        Class<One.InnerTwo> innerTwoClazz = One.InnerTwo.class;
        System.out.println("innerTwoClazz.getEnclosingClass() : " + innerTwoClazz.getEnclosingClass());
        System.out.println("innerTwoClazz.getEnclosingMethod() : " + innerTwoClazz.getEnclosingMethod());
        System.out.println("innerTwoClazz.getEnclosingConstructor() : " + innerTwoClazz.getEnclosingConstructor());

    }

}
