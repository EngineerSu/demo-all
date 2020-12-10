package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.mybatis.dataobject.UserDO;

@Mapper
public interface UserMapper {
    void insert(UserDO userDO);

    UserDO selectByName(String name);
}
