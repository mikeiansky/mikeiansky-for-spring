package sun.net.www.protocol.w;

import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class HandlerTest {

    public static void main(String[] args) throws IOException {

        URL url = new URL("w:///winson.txt");
        InputStream in = url.openStream();
        String result = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
        System.out.println(result);

    }

}
