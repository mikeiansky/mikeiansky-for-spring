package com.winson.spring.bean.metadata;

import com.winson.spring.overview.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class WinsonContextDemo {

    public static void main(String[] args) {

        String path = "classpath:/META-INF/winson-context.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);

        System.out.println(context.getBean(User.class));

    }

}
