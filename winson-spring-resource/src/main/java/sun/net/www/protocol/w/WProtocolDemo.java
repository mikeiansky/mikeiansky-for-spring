package sun.net.www.protocol.w;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author winson
 * @date 2021/6/29
 **/
public class WProtocolDemo {

    public static void main(String[] args) throws IOException {
        URL url = new URL("w:///META-INF/default.properties");
        System.out.println("protocol:" + url.getProtocol());
        System.out.println("host:" + url.getHost());
        System.out.println("path:" + url.getPath());
        InputStream inputStream = url.openStream();
//        String result = IOUtils.toString(inputStream, "gbk");
        String result = IOUtils.toString(inputStream, "utf-8");
        System.out.println(result);
    }

}
