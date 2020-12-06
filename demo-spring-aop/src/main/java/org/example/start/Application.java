package org.example.start;

import org.example.pojo.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Calculator calculator = (Calculator) applicationContext.getBean("calculator");
        int sum = calculator.add(5, 5);
        logger.info("sum:{}", sum);
    }

}