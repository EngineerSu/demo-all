package org.example.mybatis.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
public class MybatisConfiguration {

    @Bean(name = "dataSource")
    public BasicDataSource getBasicDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo?characterEncoding=utf-8&serverTimezone=GMT");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean res = new SqlSessionFactoryBean();
        res.setDataSource(dataSource);
        res.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return res;
    }

    // 有了 MapperScan 注解，就不用单独去为每一个 Mapper 接口声明以下这类 bean 对象
    /*@Bean(name = "userMapper")
    public MapperFactoryBean<UserMapper> getUserMapper(SqlSessionFactoryBean sqlSessionFactory) throws Exception {
        MapperFactoryBean<UserMapper> res = new MapperFactoryBean<>();
        res.setMapperInterface(UserMapper.class);
        res.setSqlSessionFactory(sqlSessionFactory.getObject());
        return res;
    }*/

}
