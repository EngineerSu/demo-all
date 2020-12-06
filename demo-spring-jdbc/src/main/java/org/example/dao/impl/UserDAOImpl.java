package org.example.dao.impl;

import org.example.dao.UserDAO;
import org.example.mapper.UserRowMapper;
import org.example.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Types;
import java.util.List;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public void save(User user) {
        jdbcTemplate.update("insert into user(name,sex,age) values(?,?,?)",
                new Object[]{user.getName(), user.getSex(), user.getAge()},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.INTEGER});
    }

    public List<User> queryAll() {
        return jdbcTemplate.query("select * from user", new UserRowMapper());
    }
}
