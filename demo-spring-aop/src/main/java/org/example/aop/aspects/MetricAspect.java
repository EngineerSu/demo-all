package org.example.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.aop.annotations.Metric;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MetricAspect {

    /**
     * Before 注解中的 value 属性表示切入点
     */
    @Before(value = "@annotation(metric)")
    public void metricBefore(Metric metric) {
        System.out.printf("method:[%s] begin metric !%n", metric.methodName());
    }

    /**
     * Around 注解中的 value 属性表示切入点
     */
    @Around(value = "@annotation(metric)")
    public Object metricAround(ProceedingJoinPoint joinPoint, Metric metric) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long spend = System.currentTimeMillis() - start;
            String msg = String.format("method:[%s], spendTime:[%s]ms", metric.methodName(), spend);
            System.out.println(msg);
            // 可以输出到监控日志
        }
    }
}
