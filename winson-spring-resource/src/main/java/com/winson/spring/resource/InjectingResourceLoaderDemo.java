package com.winson.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author winson
 * @date 2021/6/29
 **/
public class InjectingResourceLoaderDemo implements ResourceLoaderAware {

    @PostConstruct
    private void myInit(){
        System.out.println("myInit ==> current project path : " + currentProjectPath);
        System.out.println("myInit ==> resourceLoader : " + resourceLoader);
        System.out.println("myInit ==> resourceLoaders : " + resourceLoaders);
    }

    private ResourceLoader resourceLoader;

    @Autowired
    private ResourceLoader[] resourceLoaders;

    @Value("${user.dir}")
    private String currentProjectPath;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(InjectingResourceLoaderDemo.class);
        applicationContext.refresh();
        applicationContext.close();

    }

}
