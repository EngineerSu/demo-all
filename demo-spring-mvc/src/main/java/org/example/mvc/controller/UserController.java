package org.example.mvc.controller;

import com.alibaba.fastjson.JSON;
import org.example.mvc.dataobject.UserDO;
import org.example.mvc.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * RestController = Controller + ResponseBody
 */
@RestController
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserMapper userMapper;

    /**
     * 演示 RequestParam 使用，如果不声明 produces，返回对象会以默认格式透出（可能是 xml 标签）
     * produces 的声明要生效依赖 jackson
     */
    @RequestMapping(path = "queryByUserId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDO queryByUserId(@RequestParam("id") Long id) {
        logger.info("queryByUserId id:{}", id);
        UserDO userDO = userMapper.selectById(id);
        logger.info("queryByUserId userDO:{}", JSON.toJSONString(userDO));
        return userDO;
    }

    /**
     * 演示 RequestBody 使用
     */
    @RequestMapping(path = "insert", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String insertUser(@RequestBody UserDO userDO) {
        logger.info("insertUser userDO:{}", userDO);
        userMapper.insert(userDO);
        logger.info("insertUser userDOId:{}", userDO.getId());
        return "insert userDO return id:" +  userDO.getId();
    }

}
