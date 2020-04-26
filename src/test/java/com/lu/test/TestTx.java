package com.lu.test;

import com.lu.tx.UserService;
import com.lu.tx.TxConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTx {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);

    @Test
    void test1() {
        UserService userService = context.getBean(UserService.class);
        userService.insert();
    }

    @AfterEach
    void close() {
        context.close();
    }
}
