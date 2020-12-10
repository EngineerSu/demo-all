package org.example.mybatis.dataobject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDO {
    private String name;
    private String sex;
    private int age;
}
