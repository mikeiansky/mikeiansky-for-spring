package com.winson.spring.aop.features.v2;

import com.winson.spring.aop.overviewv2.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2022/4/17
 **/
public class AspectJSchemaBasePointCutSampleDemo {

    public static void main(String[] args) {

        String path = "classpath*:/META-INF/spring-aop-context-sample.xml";
//        String path = "classpath:/META-INF/spring-aop-context-sample.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
        EchoService service = context.getBean(EchoService.class);
        service.sayHello("winson");

    }

}
