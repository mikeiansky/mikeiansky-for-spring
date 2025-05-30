package io.github.mikeiansky.spring.v6.aop.transaction;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.JdbcTransactionObjectSupport;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionStatus;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.Assert;

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
            JdbcTransactionManager manager = new JdbcTransactionManager();
            manager.setDataSource(dataSource);
            return manager;
        }

        @Transactional
        public void getUserInfo() throws SQLException {
            // 方式一获取connection
            DataSourceTransactionManager dataSourceTransactionManager = beanFactory.getBean(DataSourceTransactionManager.class);
            Object connectionHoldObj = TransactionSynchronizationManager.getResource(dataSourceTransactionManager.getDataSource());
            if (!(connectionHoldObj instanceof ConnectionHolder ch)) {
                throw new IllegalArgumentException("ConnectionHolder is not found, please check if transaction is enabled or not.");
            }
            Connection connection = ch.getConnection();
            System.out.println("get user info , connection v1 : " + connection);


            // 方式二获取connection
            DefaultTransactionStatus dts = (DefaultTransactionStatus) TransactionAspectSupport.currentTransactionStatus();
            dts.getTransaction();
            JdbcTransactionObjectSupport txObject = (JdbcTransactionObjectSupport) dts.getTransaction();
            Connection connection2 = txObject.getConnectionHolder().getConnection();


            System.out.println("get user info , connection v2 : " + connection2);
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

        System.out.println("----------- 第二次调用");
        myJdbcConfig.getUserInfo();

    }

}
