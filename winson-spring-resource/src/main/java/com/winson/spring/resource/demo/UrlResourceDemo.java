package com.winson.spring.resource.demo;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.ResourceLoader;

import java.net.MalformedURLException;

/**
 * @author winson
 * @date 2022/4/26
 **/
public class UrlResourceDemo {

    public static void main(String[] args) throws MalformedURLException {

        String path1 = "D:\\work\\java\\winson-for-spring\\winson-spring-resource\\src\\main\\resources\\META-INF\\default.properties";
        String path2 = "file:///D:/work/java/winson-for-spring/winson-spring-resource/src/main/resources/META-INF/default.properties";
        String path3 = "\\\\172.16.2.247\\资源库\\结尾句子.png";
        String path4 = "classpath:/META-INF/default.properties";
        String path5 = "/META-INF/default.properties";
        String path6 = "META-INF/default.properties";
        FileUrlResource urlResource1 = new FileUrlResource(path1);
        FileUrlResource urlResource2 = new FileUrlResource(path2);
        FileSystemResource urlResource3 = new FileSystemResource(path3);
        ClassPathResource urlResource4 = new ClassPathResource(path4);
        ClassPathResource urlResource5 = new ClassPathResource(path5);
        ClassPathResource urlResource6 = new ClassPathResource(path6);
        System.out.println("urlResource1 : "+urlResource1.exists());
        System.out.println("urlResource2 : "+urlResource2.exists());
        System.out.println("urlResource3 : "+urlResource3.exists());
        System.out.println("urlResource4 : "+urlResource4.exists());
        System.out.println("urlResource5 : "+urlResource5.exists());
        System.out.println("urlResource6 : "+urlResource6.exists());

//        ResourceLoader

    }

}
