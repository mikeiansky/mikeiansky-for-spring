package com.winson.study.spring.dependency.injection;

import com.winson.study.spring.ioc.overview.domain.User;

/**
 * @author winson
 * @date 2021/6/20
 **/
public class UserHolder {

    private User user;

    public UserHolder(){

    }

    public UserHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }

}
