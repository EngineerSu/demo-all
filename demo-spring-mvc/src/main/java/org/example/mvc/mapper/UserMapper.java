package org.example.mvc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.mvc.dataobject.UserDO;

import java.util.List;

@Mapper
public interface UserMapper {
    void insert(UserDO userDO);

    UserDO selectById(Long id);

    List<UserDO> selectByName(String name);

    List<UserDO> selectAll();
}
