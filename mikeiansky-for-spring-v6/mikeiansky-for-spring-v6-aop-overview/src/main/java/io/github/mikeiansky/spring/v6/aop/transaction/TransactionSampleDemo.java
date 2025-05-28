package io.github.mikeiansky.spring.v6.aop.transaction;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.SimpleTransactionStatus;

import java.lang.reflect.InvocationTargetException;

/**
 * @author mike ian
 * @date 2024/12/20
 * @desc
 **/
public class TransactionSampleDemo {

//    @Aspect
//    public static class MyAspect {
//
//        public MyAspect() {
////            System.out.println("create MyAspect");
//        }
//
//        @Pointcut("execution(public * *(..))")
//        public void anyPublic() {
//            System.out.println("use any public");
//        }
//
//        @Before("anyPublic()")
//        public void beforeAnyPublic() throws InvocationTargetException, IllegalAccessException {
//            System.out.println("============> start beforeAnyPublic this : " + this);
//            MethodInvocation currentInvocation = ExposeInvocationInterceptor.currentInvocation();
////            System.out.println("currentInvocation : " + currentInvocation);
////            System.out.println("currentInvocation.getThis() : " + currentInvocation.getThis());
//            System.out.println("currentInvocation.getMethod() : " + currentInvocation.getMethod());
////            currentInvocation.getMethod().invoke(currentInvocation.getThis(), currentInvocation.getArguments());
////            System.out.println("complete beforeAnyPublic this : " + this);
//        }
//    }

    @EnableTransactionManagement
    public static class One {

        @Transactional
        public void hello(String msg) {
            System.out.println("Hello " + msg);
        }

    }

//    @EnableAspectJAutoProxy
    public static class MyConfig{

    }


    public static class MyTransactionManager implements PlatformTransactionManager {

        @Override
        public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
            System.out.println("getTransaction : " + definition);
//            return new SimpleTransactionStatus();
            return null;
        }

        @Override
        public void commit(TransactionStatus status) throws TransactionException {
            System.out.println("commit : " + status);
        }

        @Override
        public void rollback(TransactionStatus status) throws TransactionException {
            System.out.println("rollback : " + status);
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(MyConfig.class);
//        context.register(MyAspect.class);
        context.register(One.class);
        context.register(MyTransactionManager.class);
        context.refresh();

        One one = context.getBean(One.class);
        System.out.println(one);
        one.hello("sample");

    }

}
