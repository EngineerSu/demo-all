package org.example.pojo;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@ToString
@Component("admin")
public class Admin {
    /**
     * 登录名称
     */
    @Value("admin")
    private String name;
    /**
     * 登录密码
     */
    @Value("123456")
    private String password;
}