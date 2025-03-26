package com.java_lesson2.lesson2.ioc_spring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GirlMain {
    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        Girl girl = context.getBean(Girl.class);
        girl.dressUp();
    }
}