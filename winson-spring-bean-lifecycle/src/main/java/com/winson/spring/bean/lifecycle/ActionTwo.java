package com.winson.spring.bean.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author winson
 * @date 2021/10/1
 **/
public class ActionTwo {

    @Autowired
    private ActionOne one;

    public ActionOne getOne() {
        return one;
    }

    public void setOne(ActionOne one) {
        this.one = one;
    }

    public ActionTwo(){
        System.out.println("action two created ... this is : " + this);
    }

}
