package io.github.mikeiansky.spring.v6.overview.context.imports;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author mike ian
 * @date 2024/12/19
 * @desc
 **/
public class ContextImportsDemo {

    @Import(Two.class)
    public static class One {

    }


    public static class Two implements ImportBeanDefinitionRegistrar {

        @Override
        public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
            registry.registerBeanDefinition("two", new RootBeanDefinition(Two.class));
            registry.registerBeanDefinition("three", new RootBeanDefinition(Three.class));
        }

    }

    public static class Three {

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(One.class);
        context.refresh();

        One one = context.getBean(One.class);
        System.out.println(one);
        Two two = context.getBean(Two.class);
        System.out.println(two);
        Three three = context.getBean(Three.class);
        System.out.println(three);

    }

}
