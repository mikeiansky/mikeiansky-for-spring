package com.winson.spring.overview.repository;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @author winson
 * @date 2021/9/23
 **/
public class UserRepository {

    @Autowired
    private User user;

    @Autowired
    private ObjectFactory<ApplicationContext> objectFactory;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "user=" + user +
                ", objectFactory=" + objectFactory +
                '}';
    }

}
