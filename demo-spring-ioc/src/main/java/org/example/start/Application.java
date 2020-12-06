package org.example.start;

import org.example.pojo.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        // IOC 容器初始化
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Admin admin = (Admin) applicationContext.getBean("admin");
        String msg = String.format("admin name:[%s], password:[%s]", admin.getName(), admin.getPassword());
        System.out.println(msg);
        logger.info(msg);
    }
}