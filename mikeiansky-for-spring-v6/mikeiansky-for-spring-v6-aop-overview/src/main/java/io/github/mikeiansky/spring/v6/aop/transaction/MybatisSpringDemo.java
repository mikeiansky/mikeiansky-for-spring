package io.github.mikeiansky.spring.v6.aop.transaction;

import io.github.mikeiansky.spring.v6.aop.mapper.BlogMapper;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * @author mike ian
 * @date 2025/5/29
 * @desc
 **/
public class MybatisSpringDemo {

    @EnableTransactionManagement
    @org.springframework.context.annotation.Configuration
    public static class MyAppConfig {

        @Bean
        public DataSource dataSource() {
            String url = "jdbc:mysql://172.16.2.232:3306/mikeiansky_course?useSSL=false&serverTimezone=Asia/Shanghai&allowMultiQueries=true";
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setUrl(url);
            dataSource.setUsername("root");
            dataSource.setPassword("123456");
            return dataSource;
        }

        @Bean
        public PlatformTransactionManager transactionManager(DataSource dataSource) {
            JdbcTransactionManager jdbcTransactionManager = new JdbcTransactionManager();
            jdbcTransactionManager.setDataSource(dataSource);
            return jdbcTransactionManager;
        }

        @Bean
        public MapperFactoryBean<BlogMapper> userMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
            MapperFactoryBean<BlogMapper> factoryBean = new MapperFactoryBean<>(BlogMapper.class);
            factoryBean.setSqlSessionFactory(sqlSessionFactory);
            return factoryBean;
        }

        @Bean
        public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource);
//            return factoryBean.getObject();
            return factoryBean;
        }

    }

    public static class One {

        private BlogMapper blogMapper;

        public One(BlogMapper blogMapper) {
            this.blogMapper = blogMapper;
        }

        @Transactional
        public void hello(String msg) {
            System.out.println("Hello, " + msg + "! blogMapper : " + blogMapper);
            blogMapper.updateOne();
            blogMapper.updateOne();
            System.out.println("complete ... ");
        }

    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyAppConfig.class);
        context.register(One.class);
        context.refresh();

        One one = context.getBean(One.class);
        one.hello("world");

    }

}
