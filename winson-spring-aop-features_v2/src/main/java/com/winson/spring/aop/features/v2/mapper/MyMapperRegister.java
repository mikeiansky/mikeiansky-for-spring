package com.winson.spring.aop.features.v2.mapper;

import com.winson.spring.aop.features.v2.mybatis.CiweiMyBatisFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.aop.config.SimpleBeanFactoryAwareAspectInstanceFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author winson
 * @date 2022/4/20
 **/
public class MyMapperRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//        ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry);
        System.out.println("registerBeanDefinitions ---> ddd ");
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(CiweiMyBatisFactoryBean.class);
        registry.registerBeanDefinition("sqlSessionFactory", rootBeanDefinition);

//        AnnotatedGenericBeanDefinition rfd = new AnnotatedGenericBeanDefinition(SqlSessionFactory.class);
//        RootBeanDefinition aspectFactoryDef = new RootBeanDefinition(SqlSessionFactory.class);

//        RuntimeBeanReference ref = new RuntimeBeanReference("sqlSessionFactory");
//        MutablePropertyValues mpv = new MutablePropertyValues();
//        mpv.add("sqlSessionFactory", ref);
//
//        AnnotatedGenericBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(MapperFactoryBean.class);
//        ConstructorArgumentValues cav = new ConstructorArgumentValues();
//        cav.addIndexedArgumentValue(0, BlogMapper.class);
//        beanDefinition.setPropertyValues(mpv);
//        beanDefinition.setConstructorArgumentValues(cav);
//
//        registry.registerBeanDefinition("blogMapper", beanDefinition);

    }
}
