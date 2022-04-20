package com.winson.spring.aop.features.v2;

import org.reactivestreams.Publisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ReactiveAdapter;
import org.springframework.core.ReactiveTypeDescriptor;
import org.springframework.transaction.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionStatus;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author winson
 * @date 2022/4/19
 **/
@EnableTransactionManagement
public class TransactionalDemo implements TransactionDemoService{

    public class Hello {

    }


    private static void testException() {
        try {
            TransactionInterceptor ti = new TransactionInterceptor();

            Class clazz = Class.forName("org.springframework.transaction.interceptor.TransactionAspectSupport$ReactiveTransactionSupport");
            System.out.println("success : " + clazz);

            Class rtdc = Class.forName("org.springframework.core.ReactiveTypeDescriptor");
            Constructor cc = rtdc.getDeclaredConstructors()[0];
            cc.setAccessible(true);
            Object rtd = cc.newInstance(TransactionalDemo.class, true, true, new Supplier<Object>() {
                @Override
                public Object get() {
                    return new Object();
                }
            });
//            System.out.println("rtd : " + rtd.getClass());
            ReactiveTypeDescriptor rr = (ReactiveTypeDescriptor) rtd;
            ReactiveAdapter adapter = new ReactiveAdapter(rr, new Function<Object, Publisher<?>>() {
                @Override
                public Publisher<Object> apply(Object o) {
                    return null;
                }
            }, new Function<Publisher<?>, Object>() {
                @Override
                public Object apply(Publisher<?> publisher) {
                    return new Object();
                }
            });
            Constructor constructor = clazz.getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            System.out.println("constructor count : " + constructor.getParameterCount());
            Object target = constructor.newInstance(ti, adapter);
            System.out.println("target : " + target);
            Method method = clazz.getDeclaredMethod("isSuspend", Method.class);
            System.out.println(method);
            method.setAccessible(true);
            method.invoke(target, method);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        KotlinDelegate
    }

    @Bean
    public static TransactionManager createTransactionManager() {
//        PlatformTransactionManager transactionManager = new PlatformTransactionManager(){
//
//            @Override
//            public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
//                System.out.println("TransactionDefinition --> getTransaction status : " + definition);
//                TransactionStatus status = new DefaultTransactionStatus(definition,
//                        true,true, false, true, new Object());
//                return status;
//            }
//
//            @Override
//            public void commit(TransactionStatus status) throws TransactionException {
//                System.out.println("TransactionDefinition --> commit status : " + status);
//
//            }
//
//            @Override
//            public void rollback(TransactionStatus status) throws TransactionException {
//                System.out.println("TransactionDefinition --> rollback status : " + status);
//
//            }
//        };
//        return transactionManager;

        return new AbstractPlatformTransactionManager() {
            @Override
            protected Object doGetTransaction() throws TransactionException {
                Object obj = new Object();
                System.out.println(Thread.currentThread() + " , doGetTransaction(): " + obj);
                return obj;
            }

            @Override
            protected void doBegin(Object transaction, TransactionDefinition definition) throws TransactionException {
                System.out.println(Thread.currentThread() + " , doBegin transaction: " + transaction + " , definition : " + definition);

            }

            @Override
            protected void doCommit(DefaultTransactionStatus status) throws TransactionException {
                System.out.println(Thread.currentThread() + " , doCommit status : " + status);
                status.setCompleted();
            }

            @Override
            protected void doRollback(DefaultTransactionStatus status) throws TransactionException {
                System.out.println(Thread.currentThread() + " , doRollback status : " + status);
                status.setRollbackOnly();
            }
        };
    }

//    @Transactional(rollbackFor = Throwable.class)
    @Transactional
    public void testTransaction() throws Throwable {
        // 放在前面，先创建
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {

            @Override
            public void afterCommit() {
                System.out.println("test :: afterCommit");
            }

        });
//        TransactionSynchronizationManager.initSynchronization();
        System.out.println("testTransaction start ...!");
        if(1==1){
            throw new Throwable();
        }
        System.out.println("testTransaction end ...!");
    }

    public void normalAction(){
        System.out.println("This is normal action ... ");
    }

    public static void main(String[] args) throws Throwable {
//        try {
//            Class.forName("reactor.core.publisher.Flux");
////            Class.forName("com.winson.spring.aop.features.v2.TransactionalDemo");
//            System.out.println("success");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TransactionalDemo.class);
        context.refresh();

        TransactionDemoService demo = context.getBean(TransactionDemoService.class);
        demo.testTransaction();
        System.out.println("----------");
//        demo.normalAction();

//        testException();

    }


}
