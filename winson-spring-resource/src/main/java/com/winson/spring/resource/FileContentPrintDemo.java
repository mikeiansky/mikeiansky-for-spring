package com.winson.spring.resource;

import java.io.*;
import java.net.URL;

/**
 * @author 文翔
 * @date 2021/6/29
 **/
public class FileContentPrintDemo {

    public static void main(String[] args) throws IOException {

        URL url = FileContentPrintDemo.class.getResource("/");
//        String filePath = url.getPath()+"META-INF/aa.txt";
//        String filePath = url.getPath()+"META-INF/aaa.properties";
        String filePath = url.getPath()+"META-INF/default.properties";
//        String filePath = "D:\\work\\java\\winson-for-spring\\winson-spring-resource\\src\\main\\java\\com\\winson\\spring\\resource\\FileContentPrintDemo.java";
        File file = new File(filePath);
        FileInputStream in = new FileInputStream(file);

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine())!=null){
            sb.append(line);
            sb.append("\r\n");
        }
        System.out.println(sb);
        reader.close();

    }

}
