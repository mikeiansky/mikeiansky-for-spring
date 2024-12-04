package com.winson.spring.bean.validator;

import com.winson.spring.overview.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.*;

import java.util.Locale;

/**
 * @author winson
 * @date 2021/10/3
 **/
public class ValidatorDemo {

    static class UserValidator implements Validator {

        @Override
        public boolean supports(Class<?> clazz) {
            return clazz.equals(User.class);
        }

        @Override
        public void validate(Object target, Errors errors) {
            System.out.println("validate target : " + target + " , errors : " + errors);
            User user = (User) target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
        }
    }

    public static MessageSource createMessageSource(){
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("name.required.user", Locale.getDefault(), "===> the user name must not null");
        messageSource.addMessage("id.required", Locale.getDefault(), "the user id must not null");
        messageSource.addMessage("name.required", Locale.getDefault(), "the user name must not null");
        return messageSource;
    }

    public static void main(String[] args) {

        User user = new User();

        Errors errors = new BeanPropertyBindingResult(user, "user");
        UserValidator userValidator = new UserValidator();
        userValidator.validate(user, errors);
        System.out.println("==========");

        MessageSource messageSource = createMessageSource();

        for (ObjectError error : errors.getAllErrors()) {
//            System.out.println(error);
            System.out.println("error.getCode() : " + error.getCode());
            System.out.println(messageSource.getMessage(error.getCode(), null, Locale.getDefault()));

        }



    }

}
