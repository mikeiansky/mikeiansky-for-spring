package com.winson.spring.overview.domain;

import com.winson.spring.overview.annotation.Super;

/**
 * @author winson
 * @date 2021/9/23
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
