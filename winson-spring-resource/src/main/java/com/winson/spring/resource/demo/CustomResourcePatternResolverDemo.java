package com.winson.spring.resource.demo;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class CustomResourcePatternResolverDemo {

    public static void main(String[] args) throws IOException {

        String path = "D:\\work\\java\\winson-for-spring\\winson-spring-resource\\src\\main\\java\\com\\winson\\spring\\resource\\demo\\EncodedFileSystemResourceDemo.java";

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());
        resolver.setPathMatcher(new PathMatcher() {
            @Override
            public boolean isPattern(String path) {
                System.out.println("isPattern : " + path);
                return false;
            }

            @Override
            public boolean match(String pattern, String path) {
                System.out.println("match , pattern : " + pattern + " , path : " + path);
                return false;
            }

            @Override
            public boolean matchStart(String pattern, String path) {
                System.out.println("matchStart , pattern : " + pattern + " , path : " + path);
                return false;
            }

            @Override
            public String extractPathWithinPattern(String pattern, String path) {
                System.out.println("extractPathWithinPattern , pattern : " + pattern + " , path : " + path);
                return null;
            }

            @Override
            public Map<String, String> extractUriTemplateVariables(String pattern, String path) {
                System.out.println("extractUriTemplateVariables , pattern : " + pattern + " , path : " + path);
                return null;
            }

            @Override
            public Comparator<String> getPatternComparator(String path) {
                System.out.println("getPatternComparator path : " + path);
                return null;
            }

            @Override
            public String combine(String pattern1, String pattern2) {
                System.out.println("combine , pattern1 : " + pattern1 + " , pattern2 : " + pattern2);
                return null;
            }
        });

        Resource[] resource = resolver.getResources(path);
        Arrays.stream(resource).map(ResourceUtils::getContent).forEach(System.out::println);
    }

}
