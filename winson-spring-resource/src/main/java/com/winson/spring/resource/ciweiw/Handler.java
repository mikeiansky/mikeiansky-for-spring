package com.winson.spring.resource.ciweiw;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author winson
 * @date 2021/6/29
 **/
public class Handler extends sun.net.www.protocol.w.Handler {

    // JVM OPTIONS Params ==> -Djava.protocol.handler.pkgs=com.winson.spring.resource
    public static void main(String[] args) throws IOException {

        URL url = new URL("ciweiw:/META-INF/default.properties");
        InputStream in = url.openStream();
        System.out.println(IOUtils.toString(in));

    }

}
