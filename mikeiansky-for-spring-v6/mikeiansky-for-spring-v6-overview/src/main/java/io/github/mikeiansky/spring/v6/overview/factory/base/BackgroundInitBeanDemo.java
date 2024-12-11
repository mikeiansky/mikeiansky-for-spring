package io.github.mikeiansky.spring.v6.overview.factory.base;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mike ian
 * @date 2024/12/11
 * @desc
 **/
public class BackgroundInitBeanDemo implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware ==> " + name + ", thread : " + Thread.currentThread());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.setBootstrapExecutor(executorService);
        AnnotatedGenericBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(BackgroundInitBeanDemo.class);
        beanDefinition.setBackgroundInit(true);
        factory.registerBeanDefinition("backgroundInitBean", beanDefinition);
        System.out.println("1--------> ");
        // 需要结合factory的预处理才可生效
        factory.preInstantiateSingletons();
        System.out.println("2--------> ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        BackgroundInitBeanDemo demo = factory.getBean(BackgroundInitBeanDemo.class);
        System.out.println("3--------> ");
        System.out.println(demo);
        System.out.println("4--------> ");
        executorService.shutdownNow();
    }

}
