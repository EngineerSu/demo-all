package org.example.mapper;

import org.example.pojo.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User res = new User();
        res.setId(resultSet.getInt("id"));
        res.setName(resultSet.getString("name"));
        res.setSex(resultSet.getString("sex"));
        res.setAge(resultSet.getInt("age"));
        return res;
    }
}
