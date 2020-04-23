package com.lu.test;

import com.lu.aop.MathCalculator;
import com.lu.config.MainConfigOfAOP;
import com.lu.config.MainConfigOfLifeCycle;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAop {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

    @Test
    void test1() {
        //1.不要自己创建对象
//        MathCalculator mathCalculator = new MathCalculator();
//        mathCalculator.div(1, 1);

        MathCalculator mathCalculator = context.getBean(MathCalculator.class);
        mathCalculator.div(1, 0);

    }

    @AfterEach
    void close() {
        context.close();
    }
}
