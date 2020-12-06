package org.example.start;

import org.example.dao.UserDAO;
import org.example.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.CollectionUtils;

import java.util.List;


public class Application {

    public static void main(String[] args) {
        // IOC 容器初始化
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserDAO userDAO = (UserDAO) applicationContext.getBean("userDAO");
        User user = new User();
        user.setName("王五");
        user.setSex("男");
        user.setAge(30);
        userDAO.save(user);
        List<User> users = userDAO.queryAll();
        if (CollectionUtils.isEmpty(users)) {
            System.out.println("users is empty !");
        }
        else {
            for (User each : users) {
                System.out.println(each);
            }
        }
    }
}