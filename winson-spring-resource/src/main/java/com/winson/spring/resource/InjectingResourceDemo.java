package com.winson.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author winson
 * @date 2021/6/29
 **/
public class InjectingResourceDemo {

    @PostConstruct
    private void myInit(){
        System.out.println("myInit ==> current project path : " + currentProjectPath);
        System.out.println("myInit ==> resource : " + resource);
        System.out.println("myInit ==> resources : " + resources);
    }

    @Value("${classpath:/META-INF/default.properties}")
    private Resource resource;

    @Value("classpath*:/META-INF/*.properties")
    private Resource[] resources;

    @Value("${user.dir}")
    private String currentProjectPath;

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(InjectingResourceDemo.class);
        applicationContext.refresh();

        InjectingResourceDemo demo = applicationContext.getBean(InjectingResourceDemo.class);
        System.out.println(IOUtils.toString(demo.resource.getInputStream()));
        System.out.println("resources.length : " + demo.resources.length);
        for (Resource resource : demo.resources) {
            System.out.println(resource);
        }
        System.out.println("current project path : " + demo.currentProjectPath);

        applicationContext.close();

    }

}
