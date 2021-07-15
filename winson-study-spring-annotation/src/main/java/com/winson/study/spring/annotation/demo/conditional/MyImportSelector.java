package com.winson.study.spring.annotation.demo.conditional;

import com.winson.study.spring.annotation.bean.Blue;
import com.winson.study.spring.annotation.bean.Yellow;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author winson
 * @date 2021/7/16
 **/
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{Blue.class.getName(), Yellow.class.getName()};
    }

}
