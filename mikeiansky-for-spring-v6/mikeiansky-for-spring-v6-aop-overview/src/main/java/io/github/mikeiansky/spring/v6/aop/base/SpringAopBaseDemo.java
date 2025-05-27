package io.github.mikeiansky.spring.v6.aop.base;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.InvocationTargetException;

/**
 * @author mike ian
 * @date 2024/12/19
 * @desc
 **/
public class SpringAopBaseDemo {

    @Aspect
    public static class MyAspect {

        public MyAspect() {
//            System.out.println("create MyAspect");
        }

        @Pointcut("execution(public * *(..))")
        public void anyPublic() {
            System.out.println("use any public");
        }

        @Before("anyPublic()")
        public void beforeAnyPublic() throws InvocationTargetException, IllegalAccessException {
            System.out.println("start beforeAnyPublic this : " + this);
            MethodInvocation currentInvocation = ExposeInvocationInterceptor.currentInvocation();
            System.out.println("currentInvocation : " + currentInvocation);
            System.out.println("currentInvocation.getThis() : " + currentInvocation.getThis());
            System.out.println("currentInvocation.getMethod() : " + currentInvocation.getMethod());
            currentInvocation.getMethod().invoke(currentInvocation.getThis(), currentInvocation.getArguments());
            System.out.println("complete beforeAnyPublic this : " + this);
        }

        @Around("anyPublic()")
        public void aroundAnyPublic(ProceedingJoinPoint pjp) throws Throwable {
            System.out.println("start aroundAnyPublic");
            System.out.println("pjp : " + pjp);
            System.out.println("pjp.getClass() : " + pjp.getClass());
            System.out.println("pjp.getTarget() : " + pjp.getTarget());
//            System.out.println("pjp.getThis() : " + pjp.getThis());
            System.out.println("pjp.getArgs() : " + pjp.getArgs());
            System.out.println("pjp.getSignature() : " + pjp.getSignature());
            System.out.println("((MethodSignature)pjp.getSignature()).getMethod() : " + ((MethodSignature)pjp.getSignature()).getMethod());
            ((MethodSignature)pjp.getSignature()).getMethod().invoke(pjp.getTarget(), pjp.getArgs());
            System.out.println("pjp.getSignature().getName() : " + pjp.getSignature().getName());
            pjp.proceed();
            System.out.println("complete aroundAnyPublic");
        }
//
        @After("anyPublic()")
        public void afterAnyPublic(){
            System.out.println("afterAnyPublic");
        }

    }

    @EnableAspectJAutoProxy
    public static class One {

        public One() {
//            System.out.println("aspect configuration one");
        }

        public String hello(String msg) {
            System.out.println("one say hello msg : " + msg + " , this : " + this);
//            System.out.println("good");
            return "one msg : " + msg;
        }

    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(One.class);
        context.register(MyAspect.class);
        context.refresh();

        MyAspect myAspect = context.getBean(MyAspect.class);
//        System.out.println(myAspect);

        One one = context.getBean(One.class);
//        System.out.println(one.getClass());
//        System.out.println(one);
        one.hello("test1");
//        one.hello("test2");


    }

}
