package org.example.test;

import org.example.pojo.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= "classpath:applicationContext.xml")
public class IocTest {
    // 测试类不用打开扫描开关，因为测试环境中会自动扫描该类
    @Resource
    private Admin admin;

    @Test
    public void test() {
        String msg = String.format("admin name:[%s], password:[%s]", admin.getName(), admin.getPassword());
        System.out.println(msg);
    }

}
