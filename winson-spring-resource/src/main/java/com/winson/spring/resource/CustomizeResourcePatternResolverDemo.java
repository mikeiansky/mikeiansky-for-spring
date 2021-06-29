package com.winson.spring.resource;

import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;

/**
 * @author winson
 * @date 2021/6/29
 **/
public class CustomizeResourcePatternResolverDemo {

    public static void main(String[] args) throws IOException {
//        String packagePath = "D:\\work\\java\\winson-for-spring\\winson-spring-resource\\src\\main\\java\\com\\winson\\spring\\resource\\";
        String packagePath = "file://D:/work/java/winson-for-spring/winson-spring-resource/src/main/java/com/winson/spring/resource/";;

        String locationPattern = packagePath+"*.java";

        System.out.println("locationPattern : " + locationPattern);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(
                new FileSystemResourceLoader()
        );
        resolver.setPathMatcher(new JavaFilePathMatcher());
        Resource[] resources = resolver.getResources(locationPattern);
        System.out.println(resources.length);

    }

    static class JavaFilePathMatcher implements PathMatcher {

        @Override
        public boolean isPattern(String path) {
            System.out.println("-------> isPattern path : " + path);
            return path.endsWith(".java");
        }

        @Override
        public boolean match(String pattern, String path) {
            System.out.println("-------> match path : " + path);
            return path.endsWith(".java");
        }

        @Override
        public boolean matchStart(String pattern, String path) {
            return false;
        }

        @Override
        public String extractPathWithinPattern(String pattern, String path) {
            return null;
        }

        @Override
        public Map<String, String> extractUriTemplateVariables(String pattern, String path) {
            return null;
        }

        @Override
        public Comparator<String> getPatternComparator(String path) {
            return null;
        }

        @Override
        public String combine(String pattern1, String pattern2) {
            return null;
        }
    }


}
