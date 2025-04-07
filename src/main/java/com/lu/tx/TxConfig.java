package com.lu.tx;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 声明式事务
 *
 * 环境搭建:
 * 1.导入相关依赖
 *      数据源、数据库驱动、spring-jdbc模块
 * 2.配置数据源、jdbcTemplate操作数据库
 * 3.给方法标注 @Transactional 表示当前方法是一个事务方法
 *
 *
 * @author 小卢
 */
@ComponentScan("com.lu.tx")
@EnableTransactionManagement
@Configuration
public class TxConfig {

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql:///db2024?useUnicode=ture&characterEncoding=UTF-8&serverTimezone=GMT%2B8");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        //spring对@Configuration类会特殊处理;给容器中加组件的方法,多次调用都只是从容器中找组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
