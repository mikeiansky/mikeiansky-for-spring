package com.winson.spring.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author winson
 * @date 2021/10/1
 **/
public class ContextAnnotationBeanCycleDependencyDemo {

    public static class ChangeBeanPostProcessor implements BeanPostProcessor {

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if(CycleOne.class.isAssignableFrom(bean.getClass())){
                System.out.println("CycleOne ======> " + beanName);
                return new CycleOne();
            }
            return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
        }
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ChangeBeanPostProcessor.class);
//        context.setAllowCircularReferences(false);
        context.register(CycleOne.class);
        context.register(CycleTwo.class);

        context.refresh();

        CycleOne one = context.getBean(CycleOne.class);
        CycleTwo two = context.getBean(CycleTwo.class);
        System.out.println("==== one ====");
        System.out.println("one : " + one);
        System.out.println("one.getCycleTwo() : " + one.getCycleTwo());
        System.out.println("one.cycleTwo : " + one.cycleTwo);
        System.out.println("==== two ====");
        System.out.println("two : " + two);
        System.out.println("two.getCycleOne() : " + two.getCycleOne());

    }

}
