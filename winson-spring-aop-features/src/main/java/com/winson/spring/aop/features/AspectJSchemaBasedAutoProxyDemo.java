package com.winson.spring.aop.features;

import com.winson.spring.aop.overview.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2021/10/14
 **/
public class AspectJSchemaBasedAutoProxyDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:/META-INF/spring-aop-auto-proxy-context.xml");

        EchoService echoService = context.getBean("echoService",EchoService.class);
//        System.out.println(echoService);

        String result = echoService.echo("hello,world");
        System.out.println(result);

    }

}
