package org.example.mvc.start;

import org.example.mvc.config.BootstrapConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 这个类相当于 web.xml 的替代，作为 Spring Web 应用的启动类存在
 *
 * @author yangsu
 * @date 2020/12/12
 */
public class WebApplication implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // 引入 Spring Web 应用的上下文
        context.register(BootstrapConfig.class);
        // 声明 DispatcherServlet，它是 SpringMVC 的前端控制器
        context.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        // 声明 DispatcherServlet 匹配所有请求
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
