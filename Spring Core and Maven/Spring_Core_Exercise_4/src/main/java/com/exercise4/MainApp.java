package com.exercise4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Student student = context.getBean(Student.class);
        System.out.println("Student Bean: " + student);
        System.out.println("Enrolled Course: " + student.getCourse());

        context.close();
    }
}
