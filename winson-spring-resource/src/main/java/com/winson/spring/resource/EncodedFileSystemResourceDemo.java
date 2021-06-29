package com.winson.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * @author winson(文翔)
 * @date 2021/6/29
 **/
public class EncodedFileSystemResourceDemo {

    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
        String filePath = "D:/work/java/winson-for-spring/winson-spring-resource/src/main/java/com/winson/spring/resource/EncodedFileSystemResourceDemo.java";
        System.out.println(filePath);
//        System.out.println(new File(filePath).exists());
        FileSystemResource fileSystemResource = new FileSystemResource(filePath);
        EncodedResource resource = new EncodedResource(fileSystemResource, "UTF-8");

        try(Reader reader = resource.getReader()){
            System.out.println(IOUtils.toString(reader));
        }
    }

}
