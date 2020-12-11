package org.example.mybatis.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 系统启动的注解配置
 *
 * @author yangsu
 * @date 2020/12/11
 */
@MapperScan(basePackages = "org.example.mybatis.mapper")
@EnableTransactionManagement(proxyTargetClass = false)
@ComponentScan(basePackages = {"org.example.mybatis"})
@Configuration
public class BootstrapConfig {

    /**
     * 用于事务
     */
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager res = new DataSourceTransactionManager();
        res.setDataSource(dataSource);
        return res;
    }
}
