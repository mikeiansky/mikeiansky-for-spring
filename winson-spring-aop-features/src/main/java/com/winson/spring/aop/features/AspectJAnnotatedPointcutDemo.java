package com.winson.spring.aop.features;

import com.winson.spring.aop.features.aspect.AspectConfiguration;
import com.winson.spring.aop.features.condition.MyAspectJCondition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Repeatable;

/**
 * @author winson
 * @date 2021/10/10
 **/
//@Configuration
@Conditional(MyAspectJCondition.class)
@EnableAspectJAutoProxy
public class AspectJAnnotatedPointcutDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AspectJAnnotatedPointcutDemo.class, AspectConfiguration.class);

        context.refresh();

        AspectJAnnotatedPointcutDemo demo = context.getBean(AspectJAnnotatedPointcutDemo.class);
//        System.out.println(demo);

        demo.execute();

        context.close();

    }

    public void execute(){
        System.out.println("demo bean execute(2) . ");
    }

}
