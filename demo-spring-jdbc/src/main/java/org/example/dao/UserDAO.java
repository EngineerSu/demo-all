package org.example.dao;

import org.example.pojo.User;

import java.util.List;

public interface UserDAO {
    /**
     * 落库保存
     */
    void save(User user);

    /**
     * 查询所有的User
     */
    List<User> queryAll();
}
