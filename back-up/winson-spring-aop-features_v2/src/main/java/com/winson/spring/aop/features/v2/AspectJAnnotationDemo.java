package com.winson.spring.aop.features.v2;

import com.winson.spring.aop.features.v2.aspect.AspectConfiguration;
import com.winson.spring.aop.features.v2.condition.MyCondition;
import com.winson.spring.aop.features.v2.myimport.MyImportSelector;
import com.winson.spring.aop.overviewv2.DefaultEchoService;
import com.winson.spring.aop.overviewv2.EchoService;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author winson
 * @date 2022/4/19
 **/
@Configuration
@Conditional(MyCondition.class)
@Import(AspectConfiguration.class)
//@Import(MyImportSelector.class)
//@Import(MyImportRegister.class)
@EnableAspectJAutoProxy
public class AspectJAnnotationDemo {

//    @Transactional
//    public void test(){
//        TransactionSynchronizationManager.initSynchronization();
//        System.out.println("demo do test!");
//        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
//            @Override
//            public void afterCommit() {
//                System.out.println("test :: afterCommit");
//            }
//        });
//    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AspectJAnnotationDemo.class);
        context.register(DefaultEchoService.class);
//        context.register(AspectConfiguration.class);
        context.refresh();


        EchoService echoService = context.getBean(EchoService.class);
        echoService.sayHello("winson");

//        AspectJAnnotationDemo demo = context.getBean(AspectJAnnotationDemo.class);
//        demo.test();

    }

}
