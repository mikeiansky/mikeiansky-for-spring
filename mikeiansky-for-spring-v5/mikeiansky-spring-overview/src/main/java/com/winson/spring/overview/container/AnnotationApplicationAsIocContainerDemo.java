package com.winson.spring.overview.container;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringValueResolver;


/**
 * @author winson
 * @date 2021/9/23
 **/
public class AnnotationApplicationAsIocContainerDemo {

    @Bean
    public User user(){
        User user = new User();
        user.setName("annotation user");
        user.setAge(3);
        return user;
    }

    @Autowired(required = false)
    private EmbeddedValueResolverAware environmentAware;

//    @Bean
//    public EmbeddedValueResolverAware aa(){
//        return new EmbeddedValueResolverAware() {
//            @Override
//            public void setEmbeddedValueResolver(StringValueResolver resolver) {
//
//            }
//        };
//    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationApplicationAsIocContainerDemo.class);
        context.refresh();

        User user = context.getBean(User.class);
        System.out.println(user);
        System.out.println("-->"+context.getBean(AnnotationApplicationAsIocContainerDemo.class).environmentAware);

    }

}
