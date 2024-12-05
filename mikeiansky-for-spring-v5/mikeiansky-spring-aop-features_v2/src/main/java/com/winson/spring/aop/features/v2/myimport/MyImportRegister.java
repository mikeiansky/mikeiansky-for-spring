package com.winson.spring.aop.features.v2.myimport;

import com.winson.spring.aop.features.v2.aspect.AspectConfiguration;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author winson
 * @date 2022/4/19
 **/
public class MyImportRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry);
        System.out.println("registerBeanDefinitions ---->  222 ");
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry, importBeanNameGenerator);
        System.out.println("registerBeanDefinitions---->  333 ");
        RootBeanDefinition beanDefinition = new RootBeanDefinition(AspectConfiguration.class);
        registry.registerBeanDefinition("otherConfiguration", beanDefinition);
    }
}
