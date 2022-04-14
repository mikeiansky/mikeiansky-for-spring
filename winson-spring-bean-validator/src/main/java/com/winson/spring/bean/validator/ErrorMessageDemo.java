package com.winson.spring.bean.validator;

import com.winson.spring.overview.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.Locale;

/**
 * @author winson
 * @date 2021/10/3
 **/
public class ErrorMessageDemo {

    public static void main(String[] args) {

        User user = new User();

        Errors errors = new BeanPropertyBindingResult(user, "user");

        errors.reject("name.required", "user name is null default 2");

        MessageSource messageSource = ValidatorDemo.createMessageSource();

        System.out.println("object errors : " + errors.getGlobalErrors());
        System.out.println("field errors : " + errors.getFieldErrors());

        System.out.println("======");
        for (ObjectError error : errors.getAllErrors()) {
//            System.out.println(errors);
            System.out.println("error code : " + error.getCode());
            System.out.println(messageSource.getMessage(error.getCode(), null, Locale.getDefault()));
//            System.out.println(messageSource.getMessage(error.getCode(), null, Locale.getDefault()));
        }

    }

}
