package com.winson.spring.utils.domain;

import com.winson.spring.utils.annotation.School;
import com.winson.spring.utils.annotation.User;
import com.winson.spring.utils.annotation.UserGroup;

/**
 * @author winson
 * @date 2021/10/12
 **/
@UserGroup(groupName = "student", groupCount = 24)
@User(name = "ciwei", age = 6)
public class Student {

    @User(name = "winson")
    private String name;

    @School(address = "shenzhen")
    private String school;

    @User(age = 24)
    public int findAge() {
        return 0;
    }

    public Student() {

    }

    @User
    public Student(@School(address = "shanghai", size = 9527) String address) {

    }

    public void display(@User(name = "zwx") String name, @User(age = 35) int age) {

    }

}
