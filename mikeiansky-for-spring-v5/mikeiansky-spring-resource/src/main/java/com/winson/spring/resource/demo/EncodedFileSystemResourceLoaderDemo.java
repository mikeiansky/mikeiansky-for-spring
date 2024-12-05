package com.winson.spring.resource.demo;

import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class EncodedFileSystemResourceLoaderDemo {

    public static void main(String[] args) throws IOException {

        String path = "D:\\work\\java\\winson-for-spring\\winson-spring-resource\\src\\main\\java\\com\\winson\\spring\\resource\\demo\\EncodedFileSystemResourceDemo.java";

        FileSystemResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource resource = resourceLoader.getResource(path);
        EncodedResource encodedResource = new EncodedResource(resource);
        System.out.println(IOUtils.toString(encodedResource.getReader()));

    }

}
