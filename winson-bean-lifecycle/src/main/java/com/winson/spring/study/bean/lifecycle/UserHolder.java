package com.winson.spring.study.bean.lifecycle;

import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * @author winson
 * @date 2021/6/26
 **/
public class UserHolder implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, EnvironmentAware , InitializingBean {

    private final User user;

    private Integer number;

    private String description;

    public UserHolder(User user) {
        this.user = user;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                ", number=" + number +
                ", description='" + description + '\'' +
                '}';
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader -------> " + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory -------> " + beanFactory);

    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName -------> " + name);

    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("setEnvironment -------> " + environment);
    }

    @PostConstruct
    public void executePostConstructor(){
        System.out.println("user holder ---------> executePostConstructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("user holder ---------> afterPropertiesSet");
    }

    public void initMethod(){
        System.out.println("user holder ---------> initMethod");

    }

}
