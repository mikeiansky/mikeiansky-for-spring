package sun.net.www.protocol.w;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class Handler extends URLStreamHandler {

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        System.out.println("open connection");
        return null;
    }

}
