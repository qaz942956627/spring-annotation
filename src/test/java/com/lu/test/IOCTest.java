package com.lu.test;

import com.lu.bean.Person;
import com.lu.config.MainConfig;
import com.lu.config.MainConfig2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    void importTest() {
        printDefinitionNames(context);
    }

    @Test
    void conditionTest() {
        printDefinitionNames(context);
    }

    private void printDefinitionNames(ApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println(definitionName);
        }
    }

    @Test
    void test2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        Person person = context.getBean("person", Person.class);
        Person person2 = context.getBean("person", Person.class);
        //System.out.println(person);
    }

    @Test
    void test1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        printDefinitionNames(context);

    }
}
