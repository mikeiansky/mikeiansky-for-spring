package com.winson.study.spring.beans.factory;

import com.winson.study.spring.ioc.overview.domain.User;

/**
 * @author winson
 * @date 2021/6/19
 **/
public interface UserFactory {

    default User generateUser() {
        return User.createUser();
    }

}
