package org.example.mybatis.start;

import org.example.mybatis.dataobject.UserDO;
import org.example.mybatis.mapper.UserMapper;
import org.example.mybatis.service.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BootstrapConfig.class);
        insertTest(context);
        transactionalTest(context);
    }

    /**
     * 基本的 Mapper 执行 SQL 测试
     */
    private static void insertTest(AnnotationConfigApplicationContext context) {
        UserMapper userMapper = context.getBean(UserMapper.class);

        UserDO user1 = new UserDO("user1", "girl", 18);
        userMapper.insert(user1);
        System.out.println("====插入user1后====");
        userMapper.selectAll().forEach(System.out::println);

        UserDO user2 = new UserDO("user2", "boy", 19);
        userMapper.insert(user2);
        System.out.println("====插入user2后====");
        userMapper.selectAll().forEach(System.out::println);
    }

    /**
     * 事务测试
     */
    private static void transactionalTest(AnnotationConfigApplicationContext context) {
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        UserDO user1 = new UserDO("user1", "girl", 18);
        UserDO user2 = new UserDO("user2", "boy", 19);
        userService.insertTwoUserDo(user1, user2);
    }
}
