package com.winson.spring.aop.features.v2.mybatis;

import com.winson.spring.aop.features.v2.TransactionalDemo;
import com.winson.spring.aop.features.v2.mapper.BlogMapper;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * @author winson
 * @date 2022/4/20
 **/
public class CiweiMyBatisFactoryBean extends SqlSessionFactoryBean {

    public CiweiMyBatisFactoryBean() {
        setDataSource(TransactionalDemo.dataSource);
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, TransactionalDemo.dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        setConfiguration(configuration);
    }

}
