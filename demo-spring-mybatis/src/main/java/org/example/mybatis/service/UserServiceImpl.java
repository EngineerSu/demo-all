package org.example.mybatis.service;

import org.example.mybatis.dataobject.UserDO;
import org.example.mybatis.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public void insertTwoUserDo(UserDO user1, UserDO user2) {
        System.out.println("====未插入时====");
        userMapper.selectAll().forEach(System.out::println);

        userMapper.insert(user1);
        System.out.println("====插入user1后====");
        userMapper.selectAll().forEach(System.out::println);

        throwException();

        userMapper.insert(user2);
        System.out.println("====插入user2后====");
        userMapper.selectAll().forEach(System.out::println);
    }

    private void throwException() {
        throw new RuntimeException("测试Mybatis事务");
    }
}
