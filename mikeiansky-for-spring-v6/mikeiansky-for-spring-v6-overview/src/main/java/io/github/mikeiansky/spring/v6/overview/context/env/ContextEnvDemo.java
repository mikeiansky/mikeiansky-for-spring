package io.github.mikeiansky.spring.v6.overview.context.env;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author mike ian
 * @date 2025/5/8
 * @desc
 **/
public class ContextEnvDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();

        System.out.println("==== active profiles ====");
        for (String activeProfile : context.getEnvironment().getActiveProfiles()) {
            System.out.println(activeProfile);
        }

        System.out.println("==== default profiles ====");
        for (String defaultProfile : context.getEnvironment().getDefaultProfiles()) {
            System.out.println(defaultProfile);
        }

        System.out.println("==== other ====");
        System.out.println(context.getEnvironment().getProperty("TMP"));
    }

}
