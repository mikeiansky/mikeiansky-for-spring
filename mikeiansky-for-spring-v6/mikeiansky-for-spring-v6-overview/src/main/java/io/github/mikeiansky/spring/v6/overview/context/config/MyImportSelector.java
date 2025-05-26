package io.github.mikeiansky.spring.v6.overview.context.config;

import io.github.mikeiansky.spring.v6.overview.context.config.inner.ImportDemo;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @author mike ian
 * @date 2025/5/24
 * @desc
 **/
@Component
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                ImportDemo.Two.class.getName()
        };
    }
}
