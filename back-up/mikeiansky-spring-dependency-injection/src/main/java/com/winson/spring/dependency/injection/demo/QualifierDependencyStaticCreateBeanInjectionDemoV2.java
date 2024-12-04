package com.winson.spring.dependency.injection.demo;

import com.winson.spring.dependency.injection.annotation.*;
import com.winson.spring.dependency.injection.context.MyAnnotationContext;
import com.winson.spring.dependency.injection.other.MyGeneric;
import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Map;

/**
 * @author winson
 * @date 2021/9/25
 **/
//@Qualifier("user2") // 加上这个，相当于下面定义的所有的bean加上这个注解
@Configuration
//@GroupOne // 这里是有效的
//@GroupTwo // 这里是有效的
public class QualifierDependencyStaticCreateBeanInjectionDemoV2{

//    @Autowired
////    @Qualifier("user2")
////    @MyQualifierHierarchyOne // 这里是可以的，可以扫描到，只有一层 ，
////    @MyQualifierHierarchyTwo // 这里是可以的，可以扫描到，只有两层 ，
////    @MyQualifierHierarchyThree // 这里是不行的，无法扫描到，超过了三层
//    @Qualifier("user2") // 如果不指定就是默认的
//    private User user;

//    @Autowired
//    @Qualifier("&factoryUser")
//    private Object value;

    @Autowired
    @Qualifier("factory-user")
    private Collection<User> userCollection;

    @Autowired
    @Qualifier("factory-user")
    private Map<String, User> userMap;

    @Bean
    @Primary
//    @Qualifier("user2")
//    @Qualifier
    @GroupOne // 这样是无效的
    @GroupTwo
    public static User user1() {
        return createUser(11);
    }

    @Bean
//    @Qualifier
//    @MyQualifierHierarchyOne
//    @MyQualifierHierarchyTwo
//    @MyQualifierHierarchyThree
    public static User user2() {
        return createUser(12);
    }

    @Bean
//    @Primary
//    @Qualifier("user2")
    @Qualifier("factory-user")
    public static FactoryBean<User> factoryUser(){
        return new FactoryBean<User>() {
            @Override
            public User getObject() throws Exception {
                return createUser(13);
            }

            @Override
            public Class<?> getObjectType() {
                return User.class;
            }
        };
    }

    public static User createUser(int id) {
        User user = new User();
        user.setId(id);
        return user;
    }


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        MyAnnotationContext context = new MyAnnotationContext();
//        Class<? extends Annotation> groupOneClazz = GroupOne.class;
//        Class<? extends Annotation> groupTwoClazz = GroupTwo.class;
//        Class<? extends Annotation> cs = null;
//        context.registerBean(QualifierDependencyStaticCreateBeanInjectionDemoV2.class, "haha", cs);
        context.register(QualifierDependencyStaticCreateBeanInjectionDemoV2.class);
//        context.getRegister().registerBean(QualifierDependencyStaticCreateBeanInjectionDemoV2.class, groupOneClazz,groupOneClazz);

        context.refresh();
        QualifierDependencyStaticCreateBeanInjectionDemoV2 demo = context.getBean(QualifierDependencyStaticCreateBeanInjectionDemoV2.class);

        System.out.println("demo : " + demo);
//        System.out.println("demo.user : " + demo.user);
        System.out.println("demo.userCollection : " + demo.userCollection);
        System.out.println("demo.userMap : " + demo.userMap);
//        System.out.println("demo.value : " + demo.value);
        System.out.println("demo.user1 : " + context.getBean("user1"));
        System.out.println("demo.user2 : " + context.getBean("user2"));


        context.close();

    }

}
