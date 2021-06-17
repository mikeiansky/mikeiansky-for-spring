package com.winson.study.spring.ioc.overview.domain;

import com.winson.study.spring.ioc.overview.annotation.Super;

/**
 * @author winson
 * @date 2021/6/17
 **/
@Super
public class SuperUser extends User{

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }

}
