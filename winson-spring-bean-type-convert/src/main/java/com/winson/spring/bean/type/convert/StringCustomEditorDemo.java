package com.winson.spring.bean.type.convert;

import com.winson.spring.overview.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author winson
 * @date 2021/10/4
 **/
public class StringCustomEditorDemo {

    public static void main(String[] args) {

        String path = "classpath:/META-INF/convert-demo.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);

        User user = context.getBean(User.class);
        System.out.println(user);

        context.close();
    }

}
