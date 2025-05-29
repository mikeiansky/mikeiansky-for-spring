package io.github.mikeiansky.spring.v6.aop.transaction;

import io.github.mikeiansky.spring.v6.aop.mapper.BlogMapper;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
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
public class MybatisSimpleDemo {

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
        public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
            TransactionFactory transactionFactory = new JdbcTransactionFactory();
            Environment environment =
                    new Environment("development", transactionFactory, dataSource);
            Configuration configuration = new Configuration(environment);
            configuration.addMapper(BlogMapper.class);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(configuration);
            return sqlSessionFactory;
        }

    }

    public static class One implements BeanFactoryAware {

        private BeanFactory beanFactory;

        @Transactional
        public void hello(String msg) {
            SqlSessionFactory sqlSessionFactory = beanFactory.getBean(SqlSessionFactory.class);
            SqlSession  session = sqlSessionFactory.openSession();
            BlogMapper blogMapper = session.getMapper(BlogMapper.class);
            System.out.println("Hello, " + msg + "! blogMapper : " + blogMapper);
            blogMapper.updateOne();
            session.commit();
        }

        @Override
        public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
            this.beanFactory = beanFactory;
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
