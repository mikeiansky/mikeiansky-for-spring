package io.github.mikeiansky.spring.v6.aop.transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mike ian
 * @date 2024/12/20
 * @desc
 **/
public class TransactionSampleDemo {

    @EnableTransactionManagement
    public static class One {

        @Transactional
        public void hello(String msg) {
            System.out.println("Hello " + msg);
        }

    }


    public static class MyTransactionManager implements PlatformTransactionManager {

        @Override
        public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
            System.out.println("getTransaction : " + definition);
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
        context.register(One.class);
        context.register(MyTransactionManager.class);
        context.refresh();

        One one = context.getBean(One.class);
        System.out.println(one);
        one.hello("sample");

    }

}
