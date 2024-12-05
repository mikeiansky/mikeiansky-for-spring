package com.winson.spring.aop.overview;

/**
 * @author winson
 * @date 2021/10/8
 **/
public class ProxyEchoService implements EchoService {

    private final EchoService echoService;

    public ProxyEchoService(EchoService echoService) {
        this.echoService = echoService;
    }

    @Override
    public String echo(String message) {
        long start = System.currentTimeMillis();
        String result = echoService.echo(message);
        System.out.println(result);
        long end = System.currentTimeMillis();
        System.out.println("run echo use time : " + (end - start));
        return result;
    }
}
