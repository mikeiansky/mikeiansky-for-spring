package com.winson.spring.environment;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@Configuration
@org.springframework.context.annotation.PropertySource(value = "classpath:/default.properties")
public class WinsonSpringEnvironmentApplication {

    @Value("${classpath:/default.properties}")
    private Resource resource;

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(WinsonSpringEnvironmentApplication.class);
        context.refresh();
        Environment environment = context.getBean(Environment.class);
        System.out.println("environment:" + environment);
        ConfigurableEnvironment configurableEnvironment = context.getEnvironment();
        System.out.println("configurableEnvironment:" + configurableEnvironment);
        for (PropertySource<?> propertySource : configurableEnvironment.getPropertySources()) {
            System.out.println(propertySource.getName());
            System.out.println(propertySource.getProperty("winson.name"));
        }
        System.out.println("-----");
        WinsonSpringEnvironmentApplication demo = context.getBean(WinsonSpringEnvironmentApplication.class);
        System.out.println(demo.resource);
        System.out.println(demo.resource.getFilename());
        System.out.println(new File(demo.resource.getFilename()).exists());
        System.out.println(IOUtils.toString(new InputStreamReader(demo.resource.getInputStream())));

    }

}
