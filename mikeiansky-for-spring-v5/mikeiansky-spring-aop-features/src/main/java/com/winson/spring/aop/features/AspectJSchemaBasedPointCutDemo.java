package com.winson.spring.aop.features;

import com.winson.spring.aop.overview.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2021/10/14
 **/
public class AspectJSchemaBasedPointCutDemo {

    public static void main(String[] args) {

        String path = "classpath:/META-INF/spring-aop-context.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);

        EchoService echoService = context.getBean("proxyFactoryBean", EchoService.class);
//        System.out.println(echoService);

        String result = echoService.echo("hello,world");
        System.out.println(result);

        System.out.println("app end ... ");

    }

}
