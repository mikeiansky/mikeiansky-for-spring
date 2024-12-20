package io.github.mikeiansky.spring.v6.overview.log;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author mike ian
 * @date 2024/12/20
 * @desc
 **/
public class Slf4jLogDemo {

//    @Slf4j
    public static class One {

        private static final Logger log = LoggerFactory.getLogger(One.class);

        public void hello(String msg){
            log.info("test log from one , hello - {}", msg);
        }

    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(One.class);
        context.refresh();

        One one = context.getBean(One.class);
        one.hello("world");

        new Thread(() -> one.hello("thread")).start();

    }

}
