package com.winson.study.mvc.jetty.embed;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;


/**
 * @author winson
 * @date 2021/8/9
 **/
public class EmbeddedJettyDemo {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8081);
        ServletContextHandler handler = new ServletContextHandler(server, "/example");
        handler.addServlet(ExampleServlet.class, "/");
        server.start();
        System.out.println("main start success .... ");

        Thread.sleep(1000 * 60 * 10);

        System.out.println("main end .... ");
    }

}
