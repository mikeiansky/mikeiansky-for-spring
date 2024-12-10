package io.github.mikeiansky.spring.v6.overview.factory.dependency.injection;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author mike ian
 * @date 2024/12/10
 * @desc
 **/
public class CircleReferenceEarlySingletonObjectDemo {

    public static class One {
        private Two two;

        public void setTwo(Two two) {
            this.two = two;
        }

        public Two getTwo() {
            return two;
        }
    }

    public static class Two {
        private One one;

        public void setOne(One one) {
            this.one = one;
        }

        public One getOne() {
            return one;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        AnnotatedGenericBeanDefinition oneBeanDefinition = new AnnotatedGenericBeanDefinition(One.class);
        AnnotatedGenericBeanDefinition twoBeanDefinition = new AnnotatedGenericBeanDefinition(Two.class);

        MutablePropertyValues onePropertyValues = new MutablePropertyValues();
        RuntimeBeanReference twoBeanReference = new RuntimeBeanReference("two");
        onePropertyValues.addPropertyValue("two", twoBeanReference);
        oneBeanDefinition.setPropertyValues(onePropertyValues);

        MutablePropertyValues twoPropertyValues = new MutablePropertyValues();
        RuntimeBeanReference oneBeanReference = new RuntimeBeanReference("one");
        twoPropertyValues.addPropertyValue("one", oneBeanReference);
        twoBeanDefinition.setPropertyValues(twoPropertyValues);

        factory.registerBeanDefinition("one", oneBeanDefinition);
        factory.registerBeanDefinition("two", twoBeanDefinition);

        One one = factory.getBean(One.class);
        Two two = factory.getBean(Two.class);

        System.out.println("one is " + one);
        System.out.println("two is " + two);
        System.out.println("two of one is " + one.getTwo());
        System.out.println("one of two is " + two.getOne());

    }

}
