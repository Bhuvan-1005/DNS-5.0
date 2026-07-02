package com.exercise2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Employee empConstructor = (Employee) context.getBean("employeeConstructor");
        System.out.println("Constructor Injection: " + empConstructor);

        Employee empSetter = (Employee) context.getBean("employeeSetter");
        System.out.println("Setter Injection: " + empSetter);

        Employee empAutowired = (Employee) context.getBean("employeeAutowired");
        System.out.println("Autowired Injection: " + empAutowired);

        ((ClassPathXmlApplicationContext) context).close();
    }
}
