package com.winson.spring.bean.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * @author winson
 * @date 2021/10/1
 **/
public class ActionOne {

    @Autowired
//    @Lazy
    private ActionTwo two;

    public ActionOne(){
        System.out.println("action one created ... this is : " + this);
    }

    public ActionTwo getTwo() {
        return two;
    }

    public void setTwo(ActionTwo two) {
        this.two = two;
    }
}
