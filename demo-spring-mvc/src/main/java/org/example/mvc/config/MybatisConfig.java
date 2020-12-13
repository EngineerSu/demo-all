package org.example.mvc.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@MapperScan(basePackages = {"org.example.mvc.mapper"})
@EnableTransactionManagement(proxyTargetClass = false)
@Configuration
public class MybatisConfig {

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // serverTimezone 用于数据库与系统时区不一致时，进行声明
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo?characterEncoding=utf-8&serverTimezone=GMT");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean res = new SqlSessionFactoryBean();
        res.setDataSource(dataSource);
        res.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return res;
    }

    /**
     * 用于事务
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager res = new DataSourceTransactionManager();
        res.setDataSource(dataSource);
        return res;
    }

}
