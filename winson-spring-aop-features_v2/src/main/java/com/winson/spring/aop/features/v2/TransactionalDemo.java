package com.winson.spring.aop.features.v2;

import com.winson.spring.aop.features.v2.mapper.BlogMapper;
//import org.apache.ibatis.mapping.Environment;
//import org.apache.ibatis.session.Configuration;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.apache.ibatis.transaction.TransactionFactory;
//import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import com.winson.spring.aop.features.v2.mapper.MyMapperRegister;
import com.winson.spring.aop.features.v2.mybatis.CiweiMyBatisFactoryBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.reactivestreams.Publisher;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.ReactiveAdapter;
import org.springframework.core.ReactiveTypeDescriptor;
import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.support.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author winson
 * @date 2022/4/19
 **/
@Import(MyMapperRegister.class)
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.winson.spring.aop.features.v2.mapper")
public class TransactionalDemo implements TransactionDemoService , BeanFactoryAware {

    private BeanFactory beanFactory;

    public static DriverManagerDataSource dataSource;

    static {
        String url = "jdbc:mysql://localhost:3306/winson?useSSL=false&serverTimezone=Asia/Shanghai&allowMultiQueries=true";
        dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
    }

//    @Bean
//    public static SqlSessionFactory createSqlSessionFactory(){
//        TransactionFactory transactionFactory = new JdbcTransactionFactory();
//        Environment environment = new Environment("development", transactionFactory, dataSource);
//        Configuration configuration = new Configuration(environment);
//        configuration.addMapper(BlogMapper.class);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
//        return sqlSessionFactory;
//    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public class Hello {

    }

    private static void testException() {
        try {
            TransactionInterceptor ti = new TransactionInterceptor();

            Class clazz = Class.forName("org.springframework.transaction.interceptor.TransactionAspectSupport$ReactiveTransactionSupport");
            System.out.println("success : " + clazz);

            Class rtdc = Class.forName("org.springframework.core.ReactiveTypeDescriptor");
            Constructor cc = rtdc.getDeclaredConstructors()[0];
            cc.setAccessible(true);
            Object rtd = cc.newInstance(TransactionalDemo.class, true, true, new Supplier<Object>() {
                @Override
                public Object get() {
                    return new Object();
                }
            });
//            System.out.println("rtd : " + rtd.getClass());
            ReactiveTypeDescriptor rr = (ReactiveTypeDescriptor) rtd;
            ReactiveAdapter adapter = new ReactiveAdapter(rr, new Function<Object, Publisher<?>>() {
                @Override
                public Publisher<Object> apply(Object o) {
                    return null;
                }
            }, new Function<Publisher<?>, Object>() {
                @Override
                public Object apply(Publisher<?> publisher) {
                    return new Object();
                }
            });
            Constructor constructor = clazz.getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            System.out.println("constructor count : " + constructor.getParameterCount());
            Object target = constructor.newInstance(ti, adapter);
            System.out.println("target : " + target);
            Method method = clazz.getDeclaredMethod("isSuspend", Method.class);
            System.out.println(method);
            method.setAccessible(true);
            method.invoke(target, method);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        KotlinDelegate
    }

    @Autowired
    private BlogMapper blogMapper;

//    @Bean
    public static TransactionManager createTransactionManager() {
//        PlatformTransactionManager transactionManager = new PlatformTransactionManager(){
//
//            @Override
//            public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
//                System.out.println("TransactionDefinition --> getTransaction status : " + definition);
//                TransactionStatus status = new DefaultTransactionStatus(definition,
//                        true,true, false, true, new Object());
//                return status;
//            }
//
//            @Override
//            public void commit(TransactionStatus status) throws TransactionException {
//                System.out.println("TransactionDefinition --> commit status : " + status);
//
//            }
//
//            @Override
//            public void rollback(TransactionStatus status) throws TransactionException {
//                System.out.println("TransactionDefinition --> rollback status : " + status);
//
//            }
//        };
//        return transactionManager;

        return new AbstractPlatformTransactionManager() {
            @Override
            protected Object doGetTransaction() throws TransactionException {
                Object obj = new Object();
                System.out.println(Thread.currentThread() + " , doGetTransaction(): " + obj);
                return obj;
            }

            @Override
            protected void doBegin(Object transaction, TransactionDefinition definition) throws TransactionException {
                System.out.println(Thread.currentThread() + " , doBegin transaction: " + transaction + " , definition : " + definition);

            }

            @Override
            protected void doCommit(DefaultTransactionStatus status) throws TransactionException {
                System.out.println(Thread.currentThread() + " , doCommit status : " + status);
                status.setCompleted();
            }

            @Override
            protected void doRollback(DefaultTransactionStatus status) throws TransactionException {
                System.out.println(Thread.currentThread() + " , doRollback status : " + status);
                status.setRollbackOnly();
            }
        };
    }

    @Bean
    public static DataSourceTransactionManager getDataSourceManager(){
//        DataSource dataSource = new

        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;
    }

    @Transactional(rollbackFor = Throwable.class)
//    @Transactional
    public void testTransaction() throws Throwable {
        // 放在前面，先创建

        ConnectionHolder connectionHolder = (ConnectionHolder) new ArrayList<>(TransactionSynchronizationManager.getResourceMap().values()).get(0);
        System.out.println("connectionHolder:"+connectionHolder.getConnection());

//        Statement statement = connectionHolder.getConnection().createStatement();
//        statement.execute("update `sensitive` set content ='winson-0001' where id = 10000000");

//        ResultSet resultSet = statement.executeQuery("select * from `sensitive` ");

//        while (resultSet.next()){
//            System.out.println(resultSet.getString("content"));
//        }

//        beanFactory.getBean()

//        SqlSessionFactory sqlSessionFactory = beanFactory.getBean(SqlSessionFactory.class);
//        SqlSession session = sqlSessionFactory.openSession();
//        System.out.println("SqlSession : "+session.getConnection());
//        BlogMapper blogMapper = session.getMapper(BlogMapper.class);
//        BlogMapper blogMapper2 = session.getMapper(BlogMapper.class);
//        System.out.println("BlogMapper : " + blogMapper);
//        System.out.println("blogMapper2 : " + blogMapper2);
//        blogMapper.selectOne();
        blogMapper.updateOne();
//        session.commit();


//        System.out.println("sqlSessionFactory.getClass():"+sqlSessionFactory.getClass());
//        System.out.println(beanFactory.getBean(BlogMapper.class));

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {

            @Override
            public void afterCommit() {
                System.out.println("test :: afterCommit");
            }

        });

//        TransactionSynchronizationManager.initSynchronization();
        System.out.println("testTransaction start ...!");
//        if(1==1){
//            throw new Throwable();
//        }
        System.out.println("testTransaction end ...!");
    }

    public void normalAction(){
        System.out.println("This is normal action ... ");
    }

    public static void main(String[] args) throws Throwable {
//        try {
//            Class.forName("reactor.core.publisher.Flux");
////            Class.forName("com.winson.spring.aop.features.v2.TransactionalDemo");
//            System.out.println("success");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TransactionalDemo.class);
//        context.register(BlogMapper.class);
        context.refresh();

        TransactionDemoService demo = context.getBean(TransactionDemoService.class);
        demo.testTransaction();
        System.out.println("split --------> 222");
        demo.testTransaction();
        System.out.println("----------");
//        demo.normalAction();

//        testException();

    }


}
