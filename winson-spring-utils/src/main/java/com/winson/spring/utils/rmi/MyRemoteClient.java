package com.winson.spring.utils.rmi;

//import com.winson.rmi.demo_v1.IRemoteMath;

import com.winson.rmi.demo_v1.IRemoteMath;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author winson
 * @date 2022/4/27
 **/
public class MyRemoteClient {

    public static void main(String[] args) {

        try {
//            Registry registry = LocateRegistry.getRegistry(9527);
////            IRemoteMath iRemoteMath = (IRemoteMath) registry.lookup("winson-remote");
//            String path = "rmi://172.16.2.113:9527/winson-remote";
////            IRemoteMath iRemoteMath = (IRemoteMath) registry.lookup(path);
////            Object iRemoteMath = (Object) Naming.lookup(path);
//            IRemoteMath iRemoteMath = (IRemoteMath) Naming.lookup(path);
//            iRemoteMath.sayHello("winson-on-spring");
//            System.out.println(iRemoteMath.add(1, 3));
//            System.out.println("iRemoteMath.getClass() : "+iRemoteMath.getClass());
//            System.out.println("iRemoteMath : "+iRemoteMath);

            String path = "rmi://172.16.2.113:9527/winson-remote";
            Context context = new InitialContext();

            IRemoteMath iRemoteMath = (IRemoteMath) context.lookup(path);
            iRemoteMath.sayHello("winson-on-spring-001");

            DirContext dirContext = new InitialDirContext();

            

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
