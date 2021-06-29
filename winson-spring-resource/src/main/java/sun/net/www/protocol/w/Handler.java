package sun.net.www.protocol.w;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * @author winson
 * @date 2021/6/29
 **/
public class Handler extends URLStreamHandler {

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        System.out.println("my handler open connection --> u : " + u);
        return new WURLConnection(u);
    }

}
