package com.winson.spring.aop.features;

import com.winson.spring.aop.features.interceptor.EchoServiceMethodInterceptor;
import com.winson.spring.aop.features.pointcut.EchoServiceEchoMethodPointcut;
import com.winson.spring.aop.features.pointcut.EchoServicePointcut;
import com.winson.spring.aop.overview.DefaultEchoService;
import com.winson.spring.aop.overview.EchoService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author winson
 * @date 2021/10/14
 **/
public class PointCutApiDemo {

    public static void main(String[] args) {

        EchoServicePointcut pointcut = new EchoServicePointcut("echo", EchoService.class);

        ComposablePointcut cp = new ComposablePointcut(EchoServiceEchoMethodPointcut.INSTANCE);
        cp.intersection(pointcut.getClassFilter());
        cp.intersection(pointcut.getMethodMatcher());

        EchoServiceMethodInterceptor interceptor = new EchoServiceMethodInterceptor();

        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(cp, interceptor);

        DefaultEchoService service = new DefaultEchoService();

        ProxyFactory proxyFactory = new ProxyFactory(service);
        proxyFactory.addAdvisor(advisor);

        EchoService echoService = (EchoService) proxyFactory.getProxy();
        String result = echoService.echo("hello,world");
        System.out.println(result);


    }

}
