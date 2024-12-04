package com.winson.spring.bean.factory;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author winson
 * @date 2021/9/24
 **/
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
//        System.out.println("create user on user factory bean");
        User user = new User();
        user.setName("user-factory-bean");
        user.setAge(45);
        return user;
    }

    @Override
    public Class<User> getObjectType() {
//        System.out.println("get object type on user factory bean");
        return User.class;
    }

}
