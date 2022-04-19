package com.winson.spring.aop.features.v2;

import com.winson.spring.aop.features.v2.aspect.AspectConfiguration;
import com.winson.spring.aop.features.v2.condition.MyCondition;
import com.winson.spring.aop.overviewv2.DefaultEchoService;
import com.winson.spring.aop.overviewv2.EchoService;
import org.springframework.context.annotation.*;

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

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AspectJAnnotationDemo.class);
        context.register(DefaultEchoService.class);
//        context.register(AspectConfiguration.class);
        context.refresh();

        EchoService echoService = context.getBean(EchoService.class);
        echoService.sayHello("winson");

    }

}
