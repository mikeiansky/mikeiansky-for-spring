package com.winson.spring.bean.data.binder;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author winson
 * @date 2021/10/3
 **/
public class DataBinderDemo {

    public static void main(String[] args) {

        User user = new User();

        DataBinder dataBinder = new DataBinder(user, "user");

        Map<String, Object> map = new HashMap<>();
        map.put("id", 24);
        map.put("name", "winson");
//        map.put("age", "sex");
        map.put("temp", "temp");
        map.put("company.name", "ciwei");
        MutablePropertyValues pv = new MutablePropertyValues(map);

        dataBinder.setAutoGrowNestedPaths(false);
//        dataBinder.setIgnoreUnknownFields(true);
        dataBinder.setIgnoreInvalidFields(true);

        dataBinder.setRequiredFields("id", "name", "city");

        dataBinder.bind(pv);

        System.out.println("user : "+user);
        BindingResult bindingResult = dataBinder.getBindingResult();
//        System.out.println(bindingResult);
        bindingResult.getAllErrors().stream().forEach(System.out::println);


    }

}
