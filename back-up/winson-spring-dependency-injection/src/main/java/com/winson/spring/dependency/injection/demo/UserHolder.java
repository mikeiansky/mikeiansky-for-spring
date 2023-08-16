package com.winson.spring.dependency.injection.demo;

import com.winson.spring.overview.domain.User;

/**
 * @author winson
 * @date 2021/9/25
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
