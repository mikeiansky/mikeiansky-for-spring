package io.github.mikeiansky.spring.v6.overview.context.resource;

import org.springframework.core.io.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author mike ian
 * @date 2025/5/9
 * @desc
 **/
public class ResourceLoaderDemo {

    public static void main(String[] args) throws IOException {
        String realPath = ClassLoader.getSystemClassLoader().getResource("test.properties").getPath();
        System.out.println(realPath);

        System.out.println("===================== FileSystemResource =====================");
        Resource resource = new FileSystemResource(realPath);
        System.out.println(resource.getContentAsString(Charset.defaultCharset()));

        System.out.println("===================== FileUrlResource =====================");
        resource = new FileUrlResource(realPath);
        System.out.println(resource.getURL());
        System.out.println(resource.getFile());
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
        System.out.println(resource.getURI());
        System.out.println(resource.getContentAsString(Charset.defaultCharset()));

        System.out.println("===================== UrlResource =====================");
        String urlRealPath = "file:" + realPath;
        resource = new UrlResource(urlRealPath);
        System.out.println(resource.getURL());
        System.out.println(resource.getFile());
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
        System.out.println(resource.getURI());
        System.out.println(resource.getContentAsString(Charset.defaultCharset()));


        System.out.println("===================== PathResource =====================");
        String subRealPath = realPath.substring(1);
        resource = new PathResource(subRealPath);
        System.out.println(resource.getContentAsString(Charset.defaultCharset()));

        System.out.println("===================== ClassPathResource =====================");
        resource = new ClassPathResource("test.properties");
        File file = resource.getFile();
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        System.out.println(resource.getContentAsString(Charset.defaultCharset()));

        System.out.println("===================== DefaultResourceLoader =====================");
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        resource = resourceLoader.getResource("classpath:test.properties");
        String content = resource.getContentAsString(Charset.defaultCharset());
        System.out.println(content);


    }

}
