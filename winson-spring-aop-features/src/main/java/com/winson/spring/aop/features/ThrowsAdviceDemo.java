package com.winson.spring.aop.features;

import org.springframework.aop.framework.ProxyFactory;

import java.util.Random;

/**
 * @author winson
 * @date 2021/10/9
 **/
public class ThrowsAdviceDemo {

    public static void main(String[] args) {
        ThrowsAdviceDemo target = new ThrowsAdviceDemo();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new MyThrowsAdvice());

        ThrowsAdviceDemo demo = (ThrowsAdviceDemo) proxyFactory.getProxy();
        demo.execute();

    }

    public void execute(){
        System.out.println("throws execute ... ");
        Random random = new Random();
        boolean result = random.nextBoolean();
        if(Boolean.FALSE.equals(result)){
            throw new IllegalArgumentException(" For expose ");
        }
    }

}
