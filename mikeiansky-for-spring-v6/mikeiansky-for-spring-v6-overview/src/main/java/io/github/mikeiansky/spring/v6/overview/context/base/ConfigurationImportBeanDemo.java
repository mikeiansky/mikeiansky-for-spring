package io.github.mikeiansky.spring.v6.overview.context.base;

import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @author mike ian
 * @date 2024/12/18
 * @desc
 **/
public class ConfigurationImportBeanDemo {

    public static class One {

    }

    public static class Two {

    }

    @Component
    public static class Three {

    }

    public static class MyImportSelector implements ImportSelector {

        @Override
        public String[] selectImports(AnnotationMetadata importingClassMetadata) {
            return new String[]{Two.class.getName()};
        }
    }

    @ComponentScan(basePackages = "io.github.mikeiansky.spring.v6.overview.context.base")
    @Import({
            One.class,
            MyImportSelector.class,
    })
    @Configuration
    public static class MyConfig {


    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyConfig.class);
        context.refresh();

        MyConfig myConfig = context.getBean(MyConfig.class);
        System.out.println(myConfig);
        One one = context.getBean(One.class);
        System.out.println(one);
        Two two = context.getBean(Two.class);
        System.out.println(two);
        Three three = context.getBean(Three.class);
        System.out.println(three);
        
    }

}
