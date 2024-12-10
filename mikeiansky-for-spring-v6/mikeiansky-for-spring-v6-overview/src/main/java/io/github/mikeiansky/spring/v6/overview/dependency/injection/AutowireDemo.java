package io.github.mikeiansky.spring.v6.overview.dependency.injection;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author mike ian
 * @date 2024/12/10
 * @desc
 **/
public class AutowireDemo {

    public static class One {
        @Autowired
        private Two two;

        public Two getTwo() {
            return two;
        }
    }

    public static class Two {

    }

    public static void main(String[] args) {
        // 测试后无效，可能需要用context 进行测试
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        AnnotatedGenericBeanDefinition oneBeanDefinition = new AnnotatedGenericBeanDefinition(One.class);
//        oneBeanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        factory.registerBeanDefinition("one", oneBeanDefinition);

        AnnotatedGenericBeanDefinition twoBeanDefinition = new AnnotatedGenericBeanDefinition(Two.class);
        factory.registerBeanDefinition("two", twoBeanDefinition);

        One one = factory.getBean(One.class);
        System.out.println(one);
        System.out.println("two of one : " + one.getTwo());
    }

}
