package com.winson.study.spring.mvc.controller.pojo;

/**
 * @author winson
 * @date 2021/8/13
 **/
public class WinsonUser {

    private String userName;//": "lyf--1",
    private String contact;//": "18025855689",
    private String name;//": "中",
    private String wechat;//": "123456"

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
}
