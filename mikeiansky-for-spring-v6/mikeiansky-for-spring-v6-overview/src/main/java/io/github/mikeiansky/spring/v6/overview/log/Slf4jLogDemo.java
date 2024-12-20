package io.github.mikeiansky.spring.v6.overview.log;

import ch.qos.logback.classic.AsyncAppender;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.FileAppender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author mike ian
 * @date 2024/12/20
 * @desc
 **/
public class Slf4jLogDemo {

    private static final Logger log = LoggerFactory.getLogger(Slf4jLogDemo.class);

    static {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

        // 创建 FileAppender
        FileAppender fileAppender = new FileAppender();
        fileAppender.setContext(loggerContext);
        fileAppender.setName("FileLogger");
        fileAppender.setFile("logs/app.log"); // 设置日志文件路径
//        fileAppender.setFile("C:\\Users\\zhouw\\Desktop\\app.log"); // 设置日志文件路径

        // 设置日志格式
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(loggerContext);
        encoder.setPattern("%d{yyyy-MM-dd HH:mm:ss} %-5level [%thread] %logger{36} - %msg%n");
        encoder.start();

        // 将 encoder 添加到 appender
        fileAppender.setEncoder(encoder);
        fileAppender.start();

        // 创建 AsyncAppender
        AsyncAppender asyncAppender = new AsyncAppender();
        asyncAppender.setContext(loggerContext);
        asyncAppender.setName("AsyncAppender");
        asyncAppender.addAppender(fileAppender);
        asyncAppender.start();

        // 获取 root logger 或指定 logger
        ch.qos.logback.classic.Logger rootLogger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

        // 添加 FileAppender 到 logger
//        rootLogger.addAppender(fileAppender);
        rootLogger.addAppender(asyncAppender);
    }


    public static void hello(String msg){
        log.info("test log from one , hello - {}", msg);
    }

    public static void main(String[] args) {

        hello("world");

        new Thread(() -> hello("thread")).start();

    }

}
