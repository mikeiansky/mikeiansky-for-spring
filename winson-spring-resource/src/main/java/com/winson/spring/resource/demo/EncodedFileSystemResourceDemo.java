package com.winson.spring.resource.demo;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class EncodedFileSystemResourceDemo {

    public static void main(String[] args) throws IOException {
        String path = "D:\\work\\java\\winson-for-spring\\winson-spring-resource\\src\\main\\java\\com\\winson\\spring\\resource\\demo\\EncodedFileSystemResourceDemo.java";
        FileSystemResource resource = new FileSystemResource(path);

        EncodedResource encodedResource = new EncodedResource(resource, "utf-8");
        BufferedReader reader = new BufferedReader(encodedResource.getReader());
        System.out.println(IOUtils.toString(reader));

    }

}
