package io.github.mikeiansky.spring.v6.aop.base;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author mike ian
 * @date 2024/12/19
 * @desc
 **/
public class SpringAopBaseDemo {

    @Aspect
    public static class MyAspect {

        public MyAspect() {
            System.out.println("create MyAspect");
        }

        @Pointcut("execution(public * *(..))")
        public void anyPublic(){
            System.out.println("use any public");
        }

        @Before("anyPublic()")
        public void beforeAnyPublic(){
            System.out.println("aspect configuration before");
        }

    }

    @EnableAspectJAutoProxy
    public static class One {

        public One() {
            System.out.println("aspect configuration one");
        }

        public String hello(String msg) {
            System.out.println("one say hello msg");
            System.out.println("good");
            return "one msg : " + msg;
        }

    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(One.class);
        context.register(MyAspect.class);
        context.refresh();

        MyAspect myAspect = context.getBean(MyAspect.class);
        System.out.println(myAspect);

        One one = context.getBean(One.class);
//        System.out.println(one.getClass());
//        System.out.println(one);
        one.hello("test");


    }

}
