package com.winson.study.spring.dependency.injection;

import com.winson.study.spring.dependency.injection.annotation.InjectionUser;
import com.winson.study.spring.dependency.injection.annotation.MyAutowired;
import com.winson.study.spring.dependency.injection.annotation.UserGroup;
import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.springframework.context.annotation.AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME;

/**
 * @author winson
 * @date 2021/6/20
 **/
public class QualifyDependencyInjectionDemo {

    public static User createUser(int id) {
        User user = new User();
        user.setId(id);
        return user;
    }

//    @Autowired
//    public Collection<User> allUser;

//    @Autowired
//    @Qualifier
//    public Collection<User> qualifierUser;

//    @Autowired
//    @UserGroup
//    public Collection<User> userGroupUser;

    @Autowired
//    @Qualifier("user")
    public User normalUser;

    @MyAutowired
    public User superUser;

    @InjectionUser
    public User injectionUser;

//    @Bean
//    @Qualifier
//    public User u6() {
//        return createUser(6);
//    }
//
//    @Bean
//    @Qualifier
//    public User u7() {
//        return createUser(7);
//    }
//
//    @Bean
//    @UserGroup
//    public User u8() {
//        return createUser(8);
//    }
//
//    @Bean
//    @UserGroup
//    public User u9() {
//        return createUser(9);
//    }

//    @Bean(name = AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
//    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
//        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
//        // @Autowired + @Inject +  新注解 @InjectedUser
//        Set<Class<? extends Annotation>> autowiredAnnotationTypes =
//                new LinkedHashSet<>(asList(Autowired.class , InjectionUser.class));
//        beanPostProcessor.setAutowiredAnnotationTypes(autowiredAnnotationTypes);
//        return beanPostProcessor;
//    }

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE - 3)
    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        beanPostProcessor.setAutowiredAnnotationType(InjectionUser.class);
        return beanPostProcessor;
    }


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(QualifyDependencyInjectionDemo.class);

        String resource = "classpath:/META-INF/study-spring-ioc-dependency-lookup.xml";
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions(resource);

        applicationContext.refresh();

        QualifyDependencyInjectionDemo demo = applicationContext.getBean(QualifyDependencyInjectionDemo.class);
        System.out.println("normal user : " + demo.normalUser);
        System.out.println("super user : " + demo.superUser);
        System.out.println("injection user : " + demo.injectionUser);
//        System.out.println("all user : " + demo.allUser);
//        System.out.println("qualifier user : " + demo.qualifierUser);
//        System.out.println("user group user : " + demo.userGroupUser);


        applicationContext.close();

    }

}
