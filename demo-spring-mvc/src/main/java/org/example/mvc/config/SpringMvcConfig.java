package org.example.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
public class SpringMvcConfig {
    /**
     * 视图解析器配置
     * 方法名 viewResolver 相当于 bean 标签的 id
     * 也可以在 Bean 注解中设置 name 属性，来指定 Bean 的 id
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver res = new InternalResourceViewResolver();
        res.setPrefix("/WEB-INF/classes/views/");
        res.setSuffix(".jsp");
        res.setViewClass(JstlView.class);
        return res;
    }
}
