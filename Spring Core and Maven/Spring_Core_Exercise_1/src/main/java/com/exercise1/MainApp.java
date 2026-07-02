package com.exercise1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MessageService service = (MessageService) context.getBean("helloWorldService");
        System.out.println(service.getMessage());
        ((ClassPathXmlApplicationContext) context).close();
    }
}
