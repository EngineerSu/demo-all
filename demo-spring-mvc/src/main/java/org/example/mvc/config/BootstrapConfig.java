package org.example.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 系统启动的注解配置
 *
 * @author yangsu
 * @date 2020/12/11
 */
@ComponentScan(basePackages = {"org.example.mvc"})
@Configuration
public class BootstrapConfig {

}
