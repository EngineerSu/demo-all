package org.example.pojo;

import org.example.aop.annotations.Metric;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("calculator")
public class Calculator {
    @Metric(methodName = "Calculator.add")
    public int add(int a, int b) throws InterruptedException {
        // 模拟方法耗时
        Thread.sleep(new Random().nextInt(3000));
        return a + b;
    }
}
