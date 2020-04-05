package com.lu.test;

import com.lu.bean.Car;
import com.lu.bean.Person;
import com.lu.config.MainConfig;
import com.lu.config.MainConfig2;
import com.lu.config.MainConfigOfLifeCycle;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

    @Test
    void importTest() {
        System.out.println("容器创建完成");
        //printDefinitionNames(context);
        //context.getBean(Car.class);
        context.close();
    }

    private void printDefinitionNames(ApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println(definitionName);
        }
    }

}
