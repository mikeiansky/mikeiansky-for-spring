package com.winson.spring.aop.features.v2.myimport;

import com.winson.spring.aop.features.v2.aspect.AspectConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author winson
 * @date 2022/4/19
 **/
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{AspectConfiguration.class.getName()};
//        return new String[]{AspectConfiguration.class.getName()};
    }

}
