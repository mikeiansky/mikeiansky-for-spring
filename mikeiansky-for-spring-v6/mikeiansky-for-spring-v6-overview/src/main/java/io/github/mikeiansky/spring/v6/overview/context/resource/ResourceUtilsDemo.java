package io.github.mikeiansky.spring.v6.overview.context.resource;

import org.springframework.util.ResourceUtils;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author mike ian
 * @date 2025/5/9
 * @desc
 **/
public class ResourceUtilsDemo {

    public static void main(String[] args) throws MalformedURLException {

        URL url = ResourceUtils.toURL("https:dddd/dddaaa\\ccc");
        System.out.println(url);

    }

}
