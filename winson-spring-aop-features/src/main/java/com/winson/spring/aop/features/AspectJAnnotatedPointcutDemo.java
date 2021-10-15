package com.winson.spring.aop.features;

import com.winson.spring.aop.features.aspect.AspectConfiguration;
import com.winson.spring.aop.features.bean.User;
import com.winson.spring.aop.features.condition.MyAspectJCondition;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
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
        context.register(AspectJAnnotatedPointcutDemo.class);
        context.register(AspectConfiguration.class);
//        context.register(User.class);

        AnnotatedBeanDefinition bd = new AnnotatedGenericBeanDefinition(User.class);
        bd.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        context.registerBeanDefinition("user", bd);

        context.refresh();

        AspectJAnnotatedPointcutDemo demo = context.getBean(AspectJAnnotatedPointcutDemo.class);
//        System.out.println(demo);

        demo.execute();
        // 每次都会新生成一个代理对象
        User user = context.getBean(User.class);
        user.sayHello("hello,world");

        context.close();
    }

    public void execute() {
        System.out.println("demo bean execute(2) . ");
    }

}
