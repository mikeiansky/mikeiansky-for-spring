package com.winson.spring.resource.demo;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class ResourceUtils {

    public static String getContent(Resource resource){
        EncodedResource encodedResource = new EncodedResource(resource);
        try {
            return IOUtils.toString(encodedResource.getReader());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
