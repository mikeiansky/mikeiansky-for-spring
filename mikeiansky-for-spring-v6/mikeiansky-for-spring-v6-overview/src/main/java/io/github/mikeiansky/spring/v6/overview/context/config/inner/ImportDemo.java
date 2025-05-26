package io.github.mikeiansky.spring.v6.overview.context.config.inner;

import io.github.mikeiansky.spring.v6.overview.context.config.MyImportSelector;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author mike ian
 * @date 2025/5/24
 * @desc
 **/
public class ImportDemo {

//    @Component
    public static class One {

    }

//    @Component
    public static class Two {

    }

//        @Component
//    public static class MyImportSelector implements ImportSelector {
//
//        @Override
//        public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//            return new String[]{
//                    Two.class.getName()
//            };
//        }
//    }

    @Import(
            value = {
                    One.class,
                    MyImportSelector.class,
            }
    )
    @Component
    public static class MyImport {

    }

    @ComponentScan(basePackages = "io.github.mikeiansky.spring.v6.overview.context.config.inner")
    @Configuration
    public static class MyConfig {



    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyConfig.class);
        context.refresh();

        System.out.println(context.getBean(MyConfig.class));
        System.out.println(context.getBean(MyImport.class));
//        System.out.println(context.getBean(ContextConfigDemo.InnerConfig.class));
//        System.out.println(context.getBean(MyImportSelector.class));
        System.out.println(context.getBean(One.class));
        System.out.println(context.getBean(Two.class));
    }

}
