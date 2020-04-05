package com.lu.test;

import com.lu.bean.Bose;
import com.lu.bean.Car;
import com.lu.bean.Color;
import com.lu.config.MainConfigOfAutowired;
import com.lu.config.MainConfigOfLifeCycle;
import com.lu.dao.BookDao;
import com.lu.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

    @Test
    void importTest() {
        Bose bean = context.getBean(Bose.class);
        System.out.println(bean);
        Car car = context.getBean(Car.class);
        System.out.println(car);
        Color bean1 = context.getBean(Color.class);
        System.out.println(bean1);
    }

    private void printDefinitionNames(ApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println(definitionName);
        }
    }

}
