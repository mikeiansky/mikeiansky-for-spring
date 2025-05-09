package io.github.mikeiansky.spring.v6.overview.context.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mike ian
 * @date 2025/5/9
 * @desc
 **/
public class ContextEventDemo {

    public static class HelloEvent extends ApplicationEvent {

        public HelloEvent(Object source) {
            super(source);
        }

    }

    public static class HelloListener implements ApplicationListener<HelloEvent> {

        public HelloListener() {
            System.out.println("create HelloListener");
        }

        @Override
        public void onApplicationEvent(HelloEvent event) {
            System.out.println("onApplicationEvent: " + event);
        }
    }

    @Configuration
    public static class One {

        @Bean
        public static HelloListener helloListener() {
            System.out.println("static create helloListener");
            return new HelloListener();
        }

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.publishEvent(new HelloEvent("before refresh"));
//        context.addApplicationListener(new HelloListener());
        context.register(HelloListener.class);
//        context.publishEvent(new HelloEvent("after refresh and before register"));
        context.refresh();
//        context.start();

//        context.refresh();
//        context.publishEvent("source");
//        context.publishEvent(new HelloEvent("after refresh and before register"));
//        context.register(HelloListener.class);
//        context.getBean(One.class);
//        context.getBean(HelloListener.class);
        context.publishEvent(new HelloEvent("after refresh and after register"));

//        One one = context.getBean(One.class);
//        System.out.println(one);
//        context.close();

        System.out.println(context.getApplicationListeners());

    }

}
