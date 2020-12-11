package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.mybatis.dataobject.UserDO;

import java.util.List;

@Mapper
public interface UserMapper {
    Long insert(UserDO userDO);

    List<UserDO> selectByName(String name);

    List<UserDO> selectAll();
}
