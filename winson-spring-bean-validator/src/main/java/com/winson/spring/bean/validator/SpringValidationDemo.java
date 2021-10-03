package com.winson.spring.bean.validator;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author winson
 * @date 2021/10/3
 **/
public class SpringValidationDemo {
        String path = "classpath:/META-INF/bean-validation-context.xml";

    public static void main(String[] args) {

        String path = "classpath:/META-INF/bean-validation-context.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);

        UserProcess userProcess = context.getBean(UserProcess.class);
        System.out.println(userProcess);
        userProcess.process(new User());
        System.out.println("end ");

    }

//    @Component
//    @Validated
//    static class UserProcessor {
//
//        public void process(@Valid User user) {
//            System.out.println(user);
//        }
//
//    }

    @Component
    @Validated
    public static class UserProcess{

        public void process(@Valid User user){
            System.out.println("process user");
        }

    }


    static class User{

        @NotNull
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
