package com.winson.spring.aop.overview;

/**
 * @author winson
 * @date 2021/10/8
 **/
public class StaticProxyDemo {

    public static void main(String[] args) {

        ProxyEchoService proxyEchoService = new ProxyEchoService(new DefaultEchoService());
        proxyEchoService.echo("hello,world");

    }

}
