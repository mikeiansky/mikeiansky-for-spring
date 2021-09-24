package com.winson.spring.bean.factory;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author winson
 * @date 2021/9/24
 **/
public class DefaultUserFactoryV2 implements UserFactory, InitializingBean, DisposableBean {

    @Override
    public User createUser() {
        User user = new User();
        user.setName("user-factory");
        user.setAge(77);
        return user;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("this is user factory post construct method ... ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("this is user factory after properties set method ... ");
    }


    public void initMethod(){
        System.out.println("this is user factory init method ... ");
    }

    public void destroyMethod(){
        System.out.println("this is user factory destroy method ");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("this is user factory destroy bean ... ");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("this is user factory pre destroy method ... ");
    }

}
