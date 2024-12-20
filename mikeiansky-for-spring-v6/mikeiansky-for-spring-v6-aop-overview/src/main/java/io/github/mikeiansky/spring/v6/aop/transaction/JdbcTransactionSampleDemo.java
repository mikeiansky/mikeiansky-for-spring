package io.github.mikeiansky.spring.v6.aop.transaction;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.sql.*;

/**
 * @author mike ian
 * @date 2024/12/20
 * @desc
 **/
public class JdbcTransactionSampleDemo {

    public static DriverManagerDataSource dataSource;

    static {
        String url = "jdbc:mysql://172.16.2.232:3306/mikeiansky_course?useSSL=false&serverTimezone=Asia/Shanghai&allowMultiQueries=true";
        dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
    }

    @EnableTransactionManagement
    @Configuration
    public static class MyJdbcConfig implements BeanFactoryAware {

        private DefaultListableBeanFactory beanFactory;

        @Bean
        public static DataSourceTransactionManager getDataSourceManager(){
            DataSourceTransactionManager manager = new DataSourceTransactionManager();
            manager.setDataSource(dataSource);
            return manager;
        }

        @Transactional
        public void getUserInfo() throws SQLException {
            DataSourceTransactionManager dataSourceTransactionManager = beanFactory.getBean(DataSourceTransactionManager.class);
            Connection connection = dataSourceTransactionManager.getDataSource().getConnection();
            System.out.println("get user info , connection: " + connection);
            ResultSet resultSet = connection.createStatement().executeQuery("select * from user");
            if (resultSet.next()) {
                System.out.println("get user info , user name : " + resultSet.getString("username"));
            }

            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit() {
                    System.out.println("get user info after commit");
                }
            });
            System.out.println("get user info complete ... ");

        }

        @Override
        public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
            this.beanFactory = (DefaultListableBeanFactory) beanFactory;
        }
    }

    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyJdbcConfig.class);
        context.refresh();

        MyJdbcConfig myJdbcConfig = context.getBean(MyJdbcConfig.class);
        myJdbcConfig.getUserInfo();

    }

}
