package com.winson.spring.dependency.source.demo;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author winson
 * @date 2021/10/3
 **/
//@Configuration
//@PropertySource("classpath:/default-source.properties")
public class AllAnnotationContextUseDemo {

    @Autowired
    private Sample sample;

    @Autowired
    private Sample sampleIsCached;

    @Autowired
    @Lazy
    private Sample sampleIsLazy;

    @Autowired
    @Lazy
    private Collection<Sample> sampleCollectionLazy;

    @Autowired
    @Lazy
    private ObjectProvider<Sample> sampleObjectProviderLazy;

    // error
//    @Autowired
//    private FactoryBean<Sample> sampleFactoryBean;

    @Autowired
    private Collection<Sample> sampleCollection1;

    @Autowired
    private Collection<Sample> sampleCollection2;

    @Autowired
    private List<Sample> sampleList;

    @Autowired
    private List<Sample> sampleList2;

    @Autowired
    private Set<Sample> sampleSet;

    @Autowired
    private Map<String, Sample> sampleMap;

    @Autowired
    private ObjectFactory<Sample> sampleObjectFactory1;

    @Autowired
    private ObjectFactory<Sample> sampleObjectFactory2;

    @Autowired
    private ObjectProvider<Sample> sampleObjectProvider1;

    @Autowired
    private ObjectProvider<Sample> sampleObjectProvider2;

    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(Sample.class);
        context.register(AllAnnotationContextUseDemo.class);

        context.refresh();

        AllAnnotationContextUseDemo demo = context.getBean(AllAnnotationContextUseDemo.class);
        Sample sample = context.getBean(Sample.class);
        System.out.println("original sample : " + sample);
        System.out.println("demo.address : " + sample.address);
        System.out.println("demo.age : " + sample.age);

        System.out.println("====== demo =======");
        System.out.println("demo : " + demo);
        System.out.println("demo.sample : " + demo.sample);
        System.out.println("demo.sampleCollection1 : " + demo.sampleCollection1);
        System.out.println("demo.sampleCollection1.hashCode : " + demo.sampleCollection1.hashCode());
        System.out.println("demo.sampleCollection1.class : " + demo.sampleCollection1.getClass());
        System.out.println("demo.sampleCollection1 : " + demo.sampleCollection2);
        System.out.println("demo.sampleCollection1.hashCode : " + demo.sampleCollection2.hashCode());
        System.out.println("demo.sampleCollection1.class : " + demo.sampleCollection2.getClass());
        System.out.println("demo.sampleList : " + demo.sampleList);
        System.out.println("demo.sampleList.class : " + demo.sampleList.getClass());
        System.out.println("demo.sampleList1.hashCode : " + demo.sampleList.hashCode());
        System.out.println("demo.sampleList2.hashCode : " + demo.sampleList2.hashCode());
        System.out.println("demo.sampleList == demo.sampleList2 : " + (demo.sampleList == demo.sampleList2));
        System.out.println("demo.sampleSet : " + demo.sampleSet);
        System.out.println("demo.sampleSet.class : " + demo.sampleSet.getClass());
        System.out.println("demo.sampleMap : " + demo.sampleMap);
        System.out.println("demo.sampleMap.hashCode : " + demo.sampleMap.hashCode());
        System.out.println("demo.sampleMap.class : " + demo.sampleMap.getClass());
        System.out.println("---------");
//        System.out.println("demo.sampleFactoryBean : " + demo.sampleFactoryBean.getObject());
        System.out.println("demo.sampleObjectFactory1 : " + demo.sampleObjectFactory1);
        System.out.println("demo.sampleObjectFactory1.getObject(#1) : " + demo.sampleObjectFactory1.getObject());
        System.out.println("demo.sampleObjectFactory1.getObject(#2) : " + demo.sampleObjectFactory1.getObject());
        System.out.println("demo.sampleObjectFactory2 : " + demo.sampleObjectFactory2);
        System.out.println("demo.sampleObjectFactory2.getObject(#1) : " + demo.sampleObjectFactory2.getObject());
        System.out.println("demo.sampleObjectFactory2.getObject(#2) : " + demo.sampleObjectFactory2.getObject());
        System.out.println("demo.sampleObjectProvider1 : " + demo.sampleObjectProvider1);
        System.out.println("demo.sampleObjectProvider1.getObject(#1) : " + demo.sampleObjectProvider1.getIfAvailable());
        System.out.println("demo.sampleObjectProvider1.getObject(#2) : " + demo.sampleObjectProvider1.getIfAvailable());
        System.out.println("demo.sampleObjectProvider2 : " + demo.sampleObjectProvider2);
        System.out.println("demo.sampleObjectProvider2.getObject(#1) : " + demo.sampleObjectProvider2.getIfAvailable());
        System.out.println("demo.sampleObjectProvider2.getObject(#2) : " + demo.sampleObjectProvider2.getIfAvailable());

        context.close();

    }

}
