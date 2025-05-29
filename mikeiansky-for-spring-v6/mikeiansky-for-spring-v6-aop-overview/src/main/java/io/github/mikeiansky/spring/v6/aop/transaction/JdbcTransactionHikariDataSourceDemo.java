package io.github.mikeiansky.spring.v6.aop.transaction;

import com.zaxxer.hikari.HikariDataSource;
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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author mike ian
 * @date 2024/12/20
 * @desc
 **/
public class JdbcTransactionHikariDataSourceDemo {

    public static DriverManagerDataSource dataSource;

    static {
        String url = "jdbc:mysql://172.16.2.232:3306/mikeiansky_course?useSSL=false&serverTimezone=Asia/Shanghai&allowMultiQueries=true";
        dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    }

    @EnableTransactionManagement
    @Configuration
    public static class MyJdbcConfig implements BeanFactoryAware {

        private DefaultListableBeanFactory beanFactory;

        @Bean
        public static DataSourceTransactionManager getDataSourceManager() {
            String url = "jdbc:mysql://172.16.2.232:3306/mikeiansky_course?useSSL=false&serverTimezone=Asia/Shanghai&allowMultiQueries=true";
            HikariDataSource hikariDataSource = new HikariDataSource();
//            hikariDataSource.setDriverClassName("com.mysql.jdbc.Driver");
            hikariDataSource.setJdbcUrl(url);
            hikariDataSource.setUsername("root");
            hikariDataSource.setPassword("123456");
            hikariDataSource.setMaximumPoolSize(3);
            hikariDataSource.setMinimumIdle(3);
//            hikariDataSource.setIdleTimeout(1000); // 30分钟
//            hikariDataSource.setMaxLifetime(1000); // 3秒
//            hikariDataSource.setMaxLifetime(0l);

            JdbcTransactionManager manager = new JdbcTransactionManager();
//            manager.setDataSource(dataSource);
            manager.setDataSource(hikariDataSource);
            return manager;
        }

        @Transactional
        public void getUserInfo(long sleep, int batch) throws SQLException {
            // 方式一获取connection
            DataSourceTransactionManager dataSourceTransactionManager = beanFactory.getBean(DataSourceTransactionManager.class);
            Object connectionHoldObj = TransactionSynchronizationManager.getResource(dataSourceTransactionManager.getDataSource());
            if (!(connectionHoldObj instanceof ConnectionHolder ch)) {
                throw new IllegalArgumentException("ConnectionHolder is not found, please check if transaction is enabled or not.");
            }
            Connection connection = ch.getConnection();
            System.out.println(batch + " get user info , connection v1 : " + connection);


            // 方式二获取connection
            DefaultTransactionStatus dts = (DefaultTransactionStatus) TransactionAspectSupport.currentTransactionStatus();
            dts.getTransaction();
            JdbcTransactionObjectSupport txObject = (JdbcTransactionObjectSupport) dts.getTransaction();
            Connection connection2 = txObject.getConnectionHolder().getConnection();


            System.out.println(batch + " get user info , connection v2 : " + connection2);
            ResultSet resultSet = connection.createStatement().executeQuery("select * from user");
            if (resultSet.next()) {
                System.out.println(batch + " get user info , user name : " + resultSet.getString("username"));
            }

            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit() {
                    System.out.println(batch + " get user info after commit");
                }
            });
            System.out.println(batch + " get user info complete ... ");

            if (sleep > 0) {
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        @Override
        public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
            this.beanFactory = (DefaultListableBeanFactory) beanFactory;
        }
    }

    public static void main(String[] args) throws SQLException, InterruptedException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        System.out.println("----------- 第一次调用");
        context.register(MyJdbcConfig.class);
        context.refresh();

        MyJdbcConfig myJdbcConfig = context.getBean(MyJdbcConfig.class);
        myJdbcConfig.getUserInfo(0, 1);

//        Thread.sleep(2000);
        System.out.println("----------- 第二次调用");
        myJdbcConfig.getUserInfo(0, 2);
//        Thread.sleep(2000);

        new Thread(() -> {
            try {
                System.out.println("----------- 第三次调用");
                myJdbcConfig.getUserInfo(2000, 3);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("----------- 第四次调用");
                myJdbcConfig.getUserInfo(2000, 4);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("----------- 第五次调用");
                myJdbcConfig.getUserInfo(2000, 5);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("----------- 第六次调用");
                myJdbcConfig.getUserInfo(2000, 6);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("----------- 第七次调用");
                myJdbcConfig.getUserInfo(2000, 7);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("----------- 第八次调用");
                myJdbcConfig.getUserInfo(2000, 8);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();

    }

}
