package io.github.mikeiansky.spring.v6.overview.context.env;

import java.util.Map;
import java.util.Properties;

/**
 * @author mike ian
 * @date 2025/5/8
 * @desc
 **/
public class BaseEnvDemo {

    public static void main(String[] args) {

        Properties systemProperties = System.getProperties();
        System.out.println(systemProperties);
        Map<String,String> systemEnv = System.getenv();
        System.out.println(systemEnv);
        System.out.println(systemEnv.get("TMP"));

    }

}
