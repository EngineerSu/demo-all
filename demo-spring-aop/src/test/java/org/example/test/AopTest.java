package org.example.test;

import org.example.pojo.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= "classpath:applicationContext.xml")
public class AopTest {
    @Resource
    private Calculator calculator;

    @Test
    public void test() throws InterruptedException {
        calculator.add(5, 5);
    }

}
