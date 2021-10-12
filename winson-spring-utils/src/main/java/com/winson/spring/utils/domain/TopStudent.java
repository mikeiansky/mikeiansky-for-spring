package com.winson.spring.utils.domain;

import com.winson.spring.utils.annotation.School;
import com.winson.spring.utils.annotation.User;
import com.winson.spring.utils.annotation.UserGroup;

/**
 * @author winson
 * @date 2021/10/12
 **/
@UserGroup(groupName = "top", groupCount = 3)
public class TopStudent {

    @User(name = "topStudent")
    private String name;

    @School(address = "beijing")
    private String school;

    @User(age = 24)
    public int topAverage() {
        return 0;
    }

    public TopStudent() {

    }

    @User
    public TopStudent(@School(address = "beijing", size = 9527) String address) {

    }

    public void display(@User(name = "wenxiang") String name, @User(age = 23) int age) {

    }

}
