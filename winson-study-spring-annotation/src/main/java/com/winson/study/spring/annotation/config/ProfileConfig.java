package com.winson.study.spring.annotation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * @author winson
 * @date 2021/7/17
 **/
@PropertySource(value = "classpath:/META-INF/dbConfig.properties")
@Configuration
public class ProfileConfig implements EmbeddedValueResolverAware {

    private StringValueResolver valueResolver;

    @Value("${db.name}")
    private String name;

    @Profile("winson")
    @Bean("devDataSource")
    public DataSource devDataSource2(@Value("pwd") String pwd) {
        String dbUrl = valueResolver.resolveStringValue("${db.url}");
        System.out.println("dev db name : " + name + " , pwd : " + pwd + " , db url : " + dbUrl);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(name);
        dataSource.setPassword(pwd);
        dataSource.setUrl("lll://llaall");
//        dataSource.setDriverClassName("com.com.com");
        return dataSource;
    }

    @Profile("ciwei")
    @Bean("testDataSource")
    public DataSource testDataSource2(@Value("pwd") String pwd) {
        String dbUrl = valueResolver.resolveStringValue("${db.url}");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        System.out.println("test db name : " + name + " , pwd : " + pwd + " , db url : " + dbUrl);
        dataSource.setUsername(name);
        dataSource.setPassword(pwd);
        dataSource.setUrl("lll://test");
//        dataSource.setDriverClassName("com.com.com");
        return dataSource;
    }

    @Profile("default")
    @Bean("productDataSource")
    public DataSource productDataSource2(@Value("pwd") String pwd) {
        String dbUrl = valueResolver.resolveStringValue("${db.url}");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        System.out.println("product db name : " + name + " , pwd : " + pwd + " , db url : " + dbUrl);
        dataSource.setUsername(name);
        dataSource.setPassword(pwd);
        dataSource.setUrl("lll://test");
//        dataSource.setDriverClassName("com.com.com");
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;
    }
}
