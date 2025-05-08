package io.github.mikeiansky.spring.v6.overview.annotation.utils;

import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * @author mike ian
 * @date 2025/5/8
 * @desc
 **/
public class ConfigurationClassUtilsDemo {

    public static class MyConfig{

    }

    public static void main(String[] args) {
        Class<?> myConfig = MyConfig.class;
        Class<?> enhanceConfig = ConfigurationClassUtils.initializeConfigurationClass(MyConfig.class);
        System.out.println(myConfig);
        System.out.println(enhanceConfig);
        System.out.println(myConfig.isAssignableFrom(enhanceConfig));

    }

}
