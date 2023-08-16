package com.winson.spring.resource.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class IOUtils {

    public static String toString(Reader reader) {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(reader);
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();

    }

}
