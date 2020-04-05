package com.lu.bean;

import org.springframework.stereotype.Component;

/**
 * @author 小卢
 */
public class Car {

    public Car() {
        System.out.println("car constructor...");
    }

    public void init() {
        System.out.println("car init...");
    }

    public void destroy() {
        System.out.println("car destroy...");
    }
}
